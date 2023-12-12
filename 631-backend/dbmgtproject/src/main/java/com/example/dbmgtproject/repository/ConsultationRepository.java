package com.example.dbmgtproject.repository;

import com.example.dbmgtproject.model.Consultation;
import com.example.dbmgtproject.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;

public interface ConsultationRepository extends JpaRepository<Consultation, Integer> {
    @Query("SELECT c FROM Consultation c " +
            "WHERE c.employee = :doctor " +
            "AND c.consultationDate = :date")
    List<Consultation> findTimeSlotsForDoctor(@Param("doctor") Employee doctor,
                                              @Param("date") Date date);
}
