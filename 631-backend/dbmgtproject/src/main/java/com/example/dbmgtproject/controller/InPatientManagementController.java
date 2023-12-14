package com.example.dbmgtproject.controller;

import com.example.dbmgtproject.model.*;
import com.example.dbmgtproject.repository.ClinicBedRepository;
import com.example.dbmgtproject.repository.EmployeeRepository;
import com.example.dbmgtproject.repository.PatientRepository;
import com.example.dbmgtproject.service.InPatientManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/inptmgt")
@CrossOrigin(origins = "http://localhost:3000")
public class InPatientManagementController {
    @Autowired
    private InPatientManagementService inPatientManagementService;
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private ClinicBedRepository clinicBedRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/available-beds")
    public ResponseEntity<List<ClinicBed>> findAvailableBeds() {
        List<ClinicBed> availableBeds = inPatientManagementService.findAvailableBeds();
        return new ResponseEntity<>(availableBeds, HttpStatus.OK);
    }
    @PostMapping("/assign-patient-to-bed")
    public ResponseEntity<String> assignPatientToBed(
            @RequestParam("patientId") Integer patientId,
            @RequestParam("bedId") Integer bedId) {
        Optional<Patient> patientOptional = patientRepository.findById(patientId);
        Optional<ClinicBed> clinicBedOptional = clinicBedRepository.findById(bedId);
        if (patientOptional.isEmpty() || clinicBedOptional.isEmpty()) {
            return ResponseEntity.badRequest().body("Invalid patient or bed ID");
        }
        Patient patient = patientOptional.get();
        ClinicBed clinicBed = clinicBedOptional.get();
        inPatientManagementService.assignPatientToBed(patient, clinicBed);
        return ResponseEntity.ok("Patient assigned to bed successfully");
    }

    @PostMapping("/remove-patient-from-bed")
    public ResponseEntity<String> removePatientFromBed(
            @RequestParam("patientId") Integer patientId,
            @RequestParam("bedId") Integer bedId) {
        Optional<Patient> patientOptional = patientRepository.findById(patientId);
        Optional<ClinicBed> clinicBedOptional = clinicBedRepository.findById(bedId);
        if (patientOptional.isEmpty() || clinicBedOptional.isEmpty()) {
            return ResponseEntity.badRequest().body("Invalid patient or bed ID");
        }
        Patient patient = patientOptional.get();
        ClinicBed clinicBed = clinicBedOptional.get();
        inPatientManagementService.removePatientFromBed(patient, clinicBed);
        return ResponseEntity.ok("Patient removed from bed successfully");
    }

    @PostMapping("/assign-doctor-to-patient")
    public ResponseEntity<String> assignDoctorToPatient(
            @RequestParam("doctorId") Integer doctorId,
            @RequestParam("patientId") Integer patientId) {
        Optional<Employee> doctorOptional = employeeRepository.findById(doctorId);
        Optional<Patient> patientOptional = patientRepository.findById(patientId);
        if (doctorOptional.isEmpty() || patientOptional.isEmpty()) {
            return ResponseEntity.badRequest().body("Invalid doctor or patient ID");
        }
        Employee doctor = doctorOptional.get();
        Patient patient = patientOptional.get();
        inPatientManagementService.assignDoctorToPatient(doctor, patient);
        return ResponseEntity.ok("Doctor assigned to patient successfully");
    }

    @DeleteMapping("/remove-doctor-from-patient")
    public ResponseEntity<String> removeDoctorFromPatient(
            @RequestParam("doctorId") Integer doctorId,
            @RequestParam("patientId") Integer patientId) {
        Optional<Employee> doctorOptional = employeeRepository.findById(doctorId);
        Optional<Patient> patientOptional = patientRepository.findById(patientId);
        if (doctorOptional.isEmpty() || patientOptional.isEmpty()) {
            return ResponseEntity.badRequest().body("Invalid doctor or patient ID");
        }
        Employee doctor = doctorOptional.get();
        Patient patient = patientOptional.get();
        inPatientManagementService.removeDoctorFromPatient(doctor, patient);
        return ResponseEntity.ok("Doctor removed from patient successfully");
    }

    @PostMapping("/assign-nurse-to-patient")
    public ResponseEntity<String> assignNurseToPatient(
            @RequestParam("nurseId") Integer nurseId,
            @RequestParam("patientId") Integer patientId,
            @RequestParam("shift") Integer shift,
            @RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {

        Optional<Employee> nurseOptional = employeeRepository.findById(nurseId);
        Optional<Patient> patientOptional = patientRepository.findById(patientId);

        if (nurseOptional.isEmpty() || patientOptional.isEmpty()) {
            return ResponseEntity.badRequest().body("Invalid nurse or patient ID");
        }

        Employee nurse = nurseOptional.get();
        Patient patient = patientOptional.get();

        inPatientManagementService.assignNurseToPatient(nurse, patient, shift, date);
        return ResponseEntity.ok("Nurse assigned to patient successfully");
    }

    @DeleteMapping("/remove-nurse-from-patient")
    public ResponseEntity<String> removeNurseFromPatient(
            @RequestParam("nurseId") Integer nurseId,
            @RequestParam("patientId") Integer patientId,
            @RequestParam("shift") Integer shift,
            @RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
        Optional<Employee> nurseOptional = employeeRepository.findById(nurseId);
        Optional<Patient> patientOptional = patientRepository.findById(patientId);

        if (nurseOptional.isEmpty() || patientOptional.isEmpty()) {
            return ResponseEntity.badRequest().body("Invalid nurse or patient ID");
        }
        Employee nurse = nurseOptional.get();
        Patient patient = patientOptional.get();

        inPatientManagementService.removeNurseFromPatient(nurse, patient, date, shift);
        return ResponseEntity.ok("Nurse removed from patient successfully");
    }

    @GetMapping("/view-scheduled-surgery-per-room-per-day")
    public ResponseEntity<List<Surgery>> viewScheduledSurgeryPerRoomPerDay(
            @RequestParam("theater") String theater,
            @RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
        List<Surgery> surgeries = inPatientManagementService.viewScheduledSurgeryPerRoomPerDay(theater, date);
        return new ResponseEntity<>(surgeries, HttpStatus.OK);
    }

    @GetMapping("/view-scheduled-surgery-per-surgeon-per-day")
    public ResponseEntity<List<Surgery>> viewScheduledSurgeryPerSurgeonPerDay(
            @RequestParam("surgeonId") Integer surgeonId,
            @RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
        Optional<Employee> surgeonOptional = employeeRepository.findById(surgeonId);
//        Employee surgeon = surgeonOptional.get();
        List<Surgery> surgeries = inPatientManagementService.viewScheduledSurgeryPerSurgeonPerDay(surgeonId, date);
        return new ResponseEntity<>(surgeries, HttpStatus.OK);
    }

    @PostMapping("/book-surgery")
    public ResponseEntity<String> bookSurgery(
            @RequestParam("patientId") Integer patientId,
            @RequestParam("theater") String theater,
            @RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date,
            @RequestParam("staffIds") List<Integer> staffIds,
            @RequestParam("surgeryType") Integer surgeryType) {
        Optional<Patient> patientOptional = patientRepository.findById(patientId);
        List<Employee> staff = employeeRepository.findAllById(staffIds);
        if (patientOptional.isEmpty() || staff.isEmpty()) {
            return ResponseEntity.badRequest().body("Invalid patient or staff IDs");
        }
        Patient patient = patientOptional.get();
        inPatientManagementService.bookSurgery(patient, theater, date, staff, surgeryType);
        return ResponseEntity.ok("Surgery booked successfully");
    }

    @GetMapping("/view-scheduled-surgeries-per-patient")
    public ResponseEntity<List<Surgery>> viewScheduledSurgeriesPerPatient(
            @RequestParam("patientId") Integer patientId) {
        Optional<Patient> patientOptional = patientRepository.findById(patientId);
        Patient patient = patientOptional.get();
        List<Surgery> surgeries = inPatientManagementService.viewScheduledSurgeriesPerPatient(patientId);
        return new ResponseEntity<>(surgeries, HttpStatus.OK);
    }
}
