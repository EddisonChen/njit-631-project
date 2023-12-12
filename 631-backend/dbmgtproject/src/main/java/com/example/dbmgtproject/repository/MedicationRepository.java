package com.example.dbmgtproject.repository;

import com.example.dbmgtproject.model.Medication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicationRepository extends JpaRepository<Medication, Integer> {
}
