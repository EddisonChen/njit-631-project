package com.example.dbmgtproject.repository;

import com.example.dbmgtproject.model.Patient;
import com.example.dbmgtproject.model.PhysicianCaresFor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PhysicianCaresForRepository extends JpaRepository<PhysicianCaresFor, Integer> {
    Optional<PhysicianCaresFor> findByPatient(Patient patient);
}
