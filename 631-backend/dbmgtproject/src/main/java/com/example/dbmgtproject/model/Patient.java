package com.example.dbmgtproject.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name="PATIENT")
public class Patient implements Serializable {
    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    @JsonProperty("hasAllergyKey")
    private List<HasAllergy> hasAllergies;

    @OneToMany(mappedBy="patient", cascade = CascadeType.ALL)
    @JsonProperty("physicianCaresFoKey")
    private List<PhysicianCaresFor> physicianCaresForList;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    @JsonProperty("admittedToKey")
    private List<AdmittedTo> admittedToList;
    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    @JsonProperty("diagnosisKey")
    private List<Diagnosis> diagnoses;
    @OneToMany(mappedBy="patient", cascade = CascadeType.ALL)
    @JsonProperty("prescriptionKey")
    private List<Prescription> prescriptions;
    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    @JsonProperty("consultationKey")
    private List<Consultation> consultations;
    @OneToOne(mappedBy = "patient", cascade = CascadeType.ALL)
    private MedicalData medicalData;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    @JsonProperty("surgeryKey")
    private List<Surgery> surgeries;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    @JsonProperty("nurseCaresForKey")
    private List<NurseCaresFor> nurseCaresForList;
    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    @JsonProperty("primaryPhysicianKey")
    private List<PrimaryPhysician> primaryPhysicians;

    @Column(name="Gender", columnDefinition = "CHAR CHECK (Gender IN('M', 'F'))")
    private Character gender;
    @Id
    @Column(name="Patient_Number")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer patientNumber;

    @Column(name="DOB")
    private Date date;

    @Column(name="SSN")
    private String ssn;

    @Column(name="Blood_Type")
    private String bloodType;

    @Column(name="Address")
    private String address;

    @Column(name="Name")
    private String name;

    public Integer getPatientNumber() {
        return patientNumber;
    }

    public void setPatientNumber(Integer patientNumber) {
        this.patientNumber = patientNumber;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
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
}
