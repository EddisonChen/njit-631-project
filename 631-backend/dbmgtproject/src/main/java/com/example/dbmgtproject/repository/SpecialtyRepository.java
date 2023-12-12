package com.example.dbmgtproject.repository;

import com.example.dbmgtproject.model.Specialty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecialtyRepository extends JpaRepository<Specialty, Integer> {
}
