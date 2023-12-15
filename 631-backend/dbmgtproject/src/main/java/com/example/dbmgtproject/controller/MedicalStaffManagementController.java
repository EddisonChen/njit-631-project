package com.example.dbmgtproject.controller;

import com.example.dbmgtproject.model.Employee;
import com.example.dbmgtproject.repository.EmployeeRepository;
import com.example.dbmgtproject.service.MedicalStaffManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/medstaffmgt")
@CrossOrigin(origins = "http://localhost:3000")
public class MedicalStaffManagementController {
    @Autowired
    private MedicalStaffManagementService medicalStaffManagementService;
    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping("/add")
    public ResponseEntity<String> addStaffMember(@RequestBody Employee staffMember) {
        medicalStaffManagementService.addStaffMember(staffMember);
        return ResponseEntity.ok("Staff member added successfully");
    }

    @DeleteMapping("/remove")
    public ResponseEntity<String> removeStaffMember(@RequestParam("empId") Integer empId) {
        medicalStaffManagementService.removeStaffMember(empId);
        return ResponseEntity.ok("Staff member removed successfully");
    }

    @GetMapping("/viewByJobType")
    public ResponseEntity<List<Object[]>> viewStaffMembersByJobType(@RequestParam("empType") String empType) {
        List<Object[]> staffMembers = medicalStaffManagementService.viewStaffMembersByJobType(empType);
        return new ResponseEntity<>(staffMembers, HttpStatus.OK);
    }

    @PostMapping("/scheduleNurseShift")
    public ResponseEntity<String> scheduleNurseShift(
            @RequestParam("employeeId") Integer employeeId,
            @RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date,
            @RequestParam("shift") Integer shift) {
        Employee employee = employeeRepository.findById(employeeId).orElse(null);

        if (employee == null) {
            return ResponseEntity.badRequest().body("Invalid employee ID");
        }

        medicalStaffManagementService.scheduleNurseShift(employee, date, shift);
        return ResponseEntity.ok("Nurse shift scheduled successfully");
    }
}
