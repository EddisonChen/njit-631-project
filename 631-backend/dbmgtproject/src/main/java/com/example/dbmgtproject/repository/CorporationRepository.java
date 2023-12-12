package com.example.dbmgtproject.repository;

import com.example.dbmgtproject.model.Corporation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CorporationRepository extends JpaRepository<Corporation, Integer> {
}
