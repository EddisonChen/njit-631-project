package com.example.dbmgtproject.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import org.hibernate.annotations.Check;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="PATIENT")
public class Patient implements Serializable {
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

    public Integer getPatient_number() {
        return patient_number;
    }

    public void setPatient_number(Integer patient_number) {
        this.patient_number = patient_number;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getBlood_type() {
        return blood_type;
    }

    public void setBlood_type(String blood_type) {
        this.blood_type = blood_type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    public List<Surgery> getSurgeries() {
        return surgeries;
    }

    public void setSurgeries(List<Surgery> surgeries) {
        this.surgeries = surgeries;
    }

    @Column(name = "Name")
    private String name;

    @Column(name = "Gender", columnDefinition = "CHAR CHECK (Gender IN ('M', 'F'))")
    private Character gender;

    @OneToMany(mappedBy="patient", cascade = CascadeType.ALL)
    private List<Surgery> surgeries;
}