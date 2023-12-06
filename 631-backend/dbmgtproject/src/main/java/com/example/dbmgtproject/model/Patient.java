package com.example.dbmgtproject.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import org.hibernate.annotations.Check;

@Entity
@Table(name="PATIENT")
public class Patient {
    @Id
    @Column(name = "Patient_Number")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer patient_number;

    @Column(name = "SSN")
    private String ssn;

    @Column(name = "Blood_Type")
    private String blood_type;

    @Column(name = "Address")
    private String address;

    @Column(name = "Name")
    private String name;

    @Column(name = "Gender", columnDefinition = "CHAR CHECK (Gender IN ('M', 'F'))")
    private Character gender;
}