package com.example.dbmgtproject.repository;

import com.example.dbmgtproject.model.Diagnosis;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DiagnosisRepository extends JpaRepository<Diagnosis, Integer> {
    List<Diagnosis> findByPatientNumber(Integer patientNumber);
}
