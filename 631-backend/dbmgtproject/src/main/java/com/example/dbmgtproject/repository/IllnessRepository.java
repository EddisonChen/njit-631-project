package com.example.dbmgtproject.repository;

import com.example.dbmgtproject.model.Illness;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IllnessRepository extends JpaRepository<Illness, Integer> {
}
