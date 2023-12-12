package com.example.dbmgtproject.repository;

import com.example.dbmgtproject.model.PrimaryPhysician;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrimaryPhysicianRepository extends JpaRepository<PrimaryPhysician, Integer> {
}
