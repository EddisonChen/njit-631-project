package com.example.dbmgtproject.repository;

import com.example.dbmgtproject.model.MedicalData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalDataRepository extends JpaRepository<MedicalData, Integer> {
}
