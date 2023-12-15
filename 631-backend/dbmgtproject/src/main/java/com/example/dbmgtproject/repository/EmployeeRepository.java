package com.example.dbmgtproject.repository;

import com.example.dbmgtproject.model.Consultation;
import com.example.dbmgtproject.model.Employee;
import com.example.dbmgtproject.model.Surgery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

import java.sql.Date;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    @Query("SELECT e.name, e.empType, e.empId, e.gender, e.address, e.salary, e.phone FROM Employee e WHERE e.empType = :empType")
    List<Object[]> findByEmpType(@Param("empType")String empType);

    Employee findByEmpId(Integer empId);

}
