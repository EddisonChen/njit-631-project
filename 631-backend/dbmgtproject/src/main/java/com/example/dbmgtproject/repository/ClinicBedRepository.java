package com.example.dbmgtproject.repository;

import com.example.dbmgtproject.model.ClinicBed;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClinicBedRepository extends JpaRepository<ClinicBed, Integer> {
    List<ClinicBed> findByAdmittedToListIsNull();
}
