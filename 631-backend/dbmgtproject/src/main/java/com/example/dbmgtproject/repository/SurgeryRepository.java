package com.example.dbmgtproject.repository;

import com.example.dbmgtproject.model.Employee;
import com.example.dbmgtproject.model.Patient;
import com.example.dbmgtproject.model.Surgery;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface SurgeryRepository extends JpaRepository<Surgery, Integer> {
    List<Surgery> findSurgeriesByEmployeesEmpIdAndDate(Integer surgeonId, Date date);

    List<Surgery> findSurgeryByTheaterAndDate(String theater, Date date);

    List<Surgery> findSurgeriesByPatientPatientNumber(Integer patientNumber);
}
