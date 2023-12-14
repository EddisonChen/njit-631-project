package com.example.dbmgtproject.repository;

import com.example.dbmgtproject.model.Consultation;
import com.example.dbmgtproject.model.Employee;
import com.example.dbmgtproject.model.Surgery;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

import java.sql.Date;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
//    List<Consultation> findConsultationsByEmpIdAndConsultationDate(Employee doctor, Date date);
    List<Employee> findByEmpType(String empType);

}
