package com.example.dbmgtproject.repository;

import com.example.dbmgtproject.model.AdmittedTo;
import com.example.dbmgtproject.model.ClinicBed;
import com.example.dbmgtproject.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdmittedToRepository extends JpaRepository<AdmittedTo, Integer> {
    List<AdmittedTo> findByPatient(Patient patient);

    List<AdmittedTo> findByClinicBed(ClinicBed clinicBed);
}
