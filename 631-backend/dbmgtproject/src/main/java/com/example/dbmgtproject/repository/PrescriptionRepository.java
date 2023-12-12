package com.example.dbmgtproject.repository;

import com.example.dbmgtproject.model.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrescriptionRepository extends JpaRepository<Prescription, Integer> {
}
