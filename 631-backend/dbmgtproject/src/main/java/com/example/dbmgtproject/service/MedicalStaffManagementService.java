package com.example.dbmgtproject.service;

import com.example.dbmgtproject.model.Employee;
import com.example.dbmgtproject.model.NurseCaresFor;
import com.example.dbmgtproject.repository.EmployeeRepository;
import com.example.dbmgtproject.repository.NurseCaresForRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MedicalStaffManagementService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private NurseCaresForRepository nurseCaresForRepository;

    public void addStaffMember(Employee staffMember) {
        employeeRepository.save(staffMember);
    }

    public void removeStaffMember(Employee staffMember) {
        employeeRepository.delete(staffMember);
    }

    public List<Employee> viewStaffMembersByJobType(String empType) {
        return employeeRepository.findByEmpType(empType);
    }


    public void scheduleNurseShift(Employee employee, Date date, Integer shift) {
        NurseCaresFor nurseCaresFor = new NurseCaresFor();
        nurseCaresFor.setEmployee(employee);
        nurseCaresFor.setDate(date);
        nurseCaresFor.setShift(shift);
        nurseCaresForRepository.save(nurseCaresFor);
    }

}
