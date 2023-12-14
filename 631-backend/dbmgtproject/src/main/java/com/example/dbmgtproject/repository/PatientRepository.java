package com.example.dbmgtproject.repository;

import com.example.dbmgtproject.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
    Patient findByPatientNumber(Integer patientNumber);
}
