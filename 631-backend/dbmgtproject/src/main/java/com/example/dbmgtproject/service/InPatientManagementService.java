package com.example.dbmgtproject.service;

import com.example.dbmgtproject.model.*;
import com.example.dbmgtproject.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InPatientManagementService {
    @Autowired
    private ClinicBedRepository clinicBedRepository;
    @Autowired
    private AdmittedToRepository admittedToRepository;
    @Autowired
    private PhysicianCaresForRepository physicianCaresForRepository;
    @Autowired
    private NurseCaresForRepository nurseCaresForRepository;
    @Autowired
    private SurgeryRepository surgeryRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private PatientRepository patientRepository;

    public List<ClinicBed> findAvailableBeds() {
        return clinicBedRepository.findByAdmittedToListIsNull();
    }
    public void assignPatientToBed(Patient patient, ClinicBed clinicBed) {
        AdmittedTo admission = new AdmittedTo();
        admission.setPatient(patient);
        admission.setClinicBed(clinicBed);
        admittedToRepository.save(admission);
    }
    public void removePatientFromBed(Patient patient, ClinicBed clinicBed) {
        List<AdmittedTo> admissions = admittedToRepository.findByPatient(patient);
        List<AdmittedTo> admissionsToRemove = admissions.stream()
                .filter(admission -> admission.getClinicBed().equals(clinicBed))
                .collect(Collectors.toList());
        admissionsToRemove.forEach(admittedToRepository::delete);
    }

    public void assignDoctorToPatient(Employee doctor, Patient patient) {
        PhysicianCaresFor physicianCaresFor = new PhysicianCaresFor();
        physicianCaresFor.setEmployee(doctor);
        physicianCaresFor.setPatient(patient);
        physicianCaresForRepository.save(physicianCaresFor);
    }

    public void removeDoctorFromPatient(Employee doctor, Patient patient) {
        Optional<PhysicianCaresFor> physicianOptional = physicianCaresForRepository.findByPatient(patient);
        physicianOptional.ifPresent(physicianCaresForRepository::delete);
    }

    public void assignNurseToPatient(Employee nurse, Patient patient, Integer shift, Date date) {
        NurseCaresFor nurseCaresFor = new NurseCaresFor();
        nurseCaresFor.setEmployee(nurse);
        nurseCaresFor.setPatient(patient);
        nurseCaresFor.setDate(date);
        nurseCaresFor.setShift(shift);
        nurseCaresForRepository.save(nurseCaresFor);
    }

    public void removeNurseFromPatient(Employee nurse, Patient patient, Date date, Integer shift) {
        Optional<NurseCaresFor> nurseCaresForOptional = nurseCaresForRepository.findByEmployeeAndPatientAndDateAndShift(nurse, patient, date, shift);
        nurseCaresForOptional.ifPresent(nurseCaresForRepository::delete);
    }

    public List<Object[]> viewScheduledSurgeryPerRoomPerDay(String theater, Date date) {
        return surgeryRepository.findSurgeryByTheaterAndDate(theater, date);
    }

    public List<Surgery> viewScheduledSurgeryPerSurgeonPerDay(Integer surgeonId, Date date) {
        return surgeryRepository.findSurgeriesByEmployeesEmpIdAndDate(surgeonId, date);
    }

    @Transactional
    public void bookSurgery(Patient patient, String theater, Date date, List<Employee> staff) {
        Surgery surgery = new Surgery();
        surgery.setPatient(patient);
        surgery.setTheater(theater);
        surgery.setDate(date);
        surgery.setEmployees(staff);

        surgeryRepository.save(surgery);
    }
    public List<Object[]> viewScheduledSurgeriesPerPatient(Integer patientNumber) {
        return surgeryRepository.findSurgeriesByPatientPatientNumber(patientNumber);
    }
}
