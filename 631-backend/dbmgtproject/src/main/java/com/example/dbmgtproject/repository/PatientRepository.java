package com.example.dbmgtproject.repository;

import com.example.dbmgtproject.model.Patient;
import com.example.dbmgtproject.model.Surgery;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
    Patient findByPatientNumber(Integer patientNumber);

//    List<Surgery> findSurgeriesByPatientNumber(Integer PatientNumber);
}
