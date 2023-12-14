package com.example.dbmgtproject.service;

import com.example.dbmgtproject.model.Consultation;
import com.example.dbmgtproject.model.Surgery;
import com.example.dbmgtproject.model.Diagnosis;
import com.example.dbmgtproject.model.Employee;
import com.example.dbmgtproject.model.Patient;
import com.example.dbmgtproject.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class PatientManagementService {
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private ConsultationRepository consultationRepository;
    @Autowired
    private DiagnosisRepository diagnosisRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private SurgeryRepository surgeryRepository;

    public Patient insertNewPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public Patient viewPatientInformation(Integer patientNumber) {
        return patientRepository.findByPatientNumber(patientNumber);
    }

    public void scheduleAppointmentWithDoctor(Employee doctor, Date date, Patient patient) {
            Consultation consultation = new Consultation();
            consultation.setConsultationDate(date);
            consultation.setEmployee(doctor);
            consultation.setPatient(patient);
            consultationRepository.save(consultation);
    }

    public List<Diagnosis> checkPreviousDiagnoses(Integer patientNumber) {
        return diagnosisRepository.findByPatientPatientNumber(patientNumber);
    }

    public List<Consultation> viewScheduledConsultationsPerDoctorPerDate(Employee doctor, Date date) {
        List<Consultation> consultations = consultationRepository.findConsultationsByEmployeeAndConsultationDate(doctor, date);
        return consultations;
    }
}
