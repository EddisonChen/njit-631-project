package com.example.dbmgtproject.repository;

import com.example.dbmgtproject.model.Allergy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AllergyRepository extends JpaRepository<Allergy, Integer> {
}
