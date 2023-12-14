package com.example.dbmgtproject.controller;

import com.example.dbmgtproject.model.Consultation;
import com.example.dbmgtproject.model.Diagnosis;
import com.example.dbmgtproject.model.Employee;
import com.example.dbmgtproject.model.Patient;
import com.example.dbmgtproject.repository.EmployeeRepository;
import com.example.dbmgtproject.repository.PatientRepository;
import com.example.dbmgtproject.service.PatientManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/ptmgt")
@CrossOrigin(origins = "http://localhost:3000")
public class PatientManagementController {
    @Autowired
    private PatientManagementService patientManagementService;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private PatientRepository patientRepository;

    @PostMapping("/new")
    public ResponseEntity<Patient> insertNewPatient(@RequestBody Patient patient) {
        Patient newPatient = patientManagementService.insertNewPatient(patient);
        return new ResponseEntity<>(newPatient, HttpStatus.CREATED);
    }

    @GetMapping("/info/{patientNumber}")
    public ResponseEntity<Patient> viewPatientInformation(@PathVariable Integer patientNumber) {
        Patient patient = patientManagementService.viewPatientInformation(patientNumber);
        if (patient != null) {
            return new ResponseEntity<>(patient, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/schedule-appointment")
    public ResponseEntity<String> scheduleAppointmentWithDoctor(
            @RequestParam("doctorId") Integer doctorId,
            @RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date,
            @RequestParam("patientId") Integer patientId) {
        Employee doctor = employeeRepository.findById(doctorId).orElse(null);
        Patient patient = patientRepository.findById(patientId).orElse(null);

        if (doctor == null || patient == null) {
            return ResponseEntity.badRequest().body("Invalid doctor/patient ID");
        }
        patientManagementService.scheduleAppointmentWithDoctor(doctor, date, patient);

        return ResponseEntity.ok("Appointment scheduled successfully");
    }

    @GetMapping("/diagnoses/{patientNumber}")
    public ResponseEntity<List<Diagnosis>> checkPreviousDiagnoses(@PathVariable Integer patientNumber) {
        List<Diagnosis> diagnoses = patientManagementService.checkPreviousDiagnoses(patientNumber);
        return new ResponseEntity<>(diagnoses, HttpStatus.OK);
    }

    @GetMapping("/consultations")
    public ResponseEntity<List<Consultation>> viewScheduledConsultationsPerDoctorPerDate(
            @RequestParam("doctorId") Integer doctorId,
            @RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
        Employee doctor = employeeRepository.findById(doctorId).orElse(null);

        if (doctor == null) {
            return ResponseEntity.badRequest().body(null);
        }

        List<Consultation> consultations = patientManagementService.viewScheduledConsultationsPerDoctorPerDate(doctor, date);
        return new ResponseEntity<>(consultations, HttpStatus.OK);
    }
}
