package com.example.dbmgtproject.controller;

import com.example.dbmgtproject.service.PatientManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ptmgt")
@CrossOrigin(origins = "http://localhost:3000")
public class PatientManagementController {
    @Autowired
    private PatientManagementService patientManagementService;
}
