package com.example.dbmgtproject.repository;

import com.example.dbmgtproject.model.Employee;
import com.example.dbmgtproject.model.NurseCaresFor;
import com.example.dbmgtproject.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.Optional;

public interface NurseCaresForRepository extends JpaRepository<NurseCaresFor, Integer> {
    Optional<NurseCaresFor> findByEmployeeAndPatientAndDateAndShift(Employee nurse, Patient patient, Date date, Integer shift);
}
