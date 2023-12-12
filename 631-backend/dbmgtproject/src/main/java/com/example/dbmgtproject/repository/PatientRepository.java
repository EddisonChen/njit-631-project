package com.example.dbmgtproject.repository;

import com.example.dbmgtproject.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
    List<Patient> findByNameAndDob(String name, Date dob);

    Patient findByPatientNumber(Integer patientNumber);
}
