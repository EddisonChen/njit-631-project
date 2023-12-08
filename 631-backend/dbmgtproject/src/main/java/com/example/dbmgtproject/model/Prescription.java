package com.example.dbmgtproject.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="Prescription")
public class Prescription implements Serializable {
    @Id
    @Column(name="Prescription_Key")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer prescriptionKey;

    @Column(name="Dosage")
    private Integer dosage;

    @Column(name="Duration")
    private Integer duration;

    @Column(name="Frequency")
    private String frequency;

    @ManyToOne
    @JoinColumn(name="Medication_Code")
    @JsonProperty("medicationCode")
    private Medication medication;

    @ManyToOne
    @JoinColumn(name="Patient_Number")
    @JsonProperty("patientNumber")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name="Consultation_Date")
    @JsonProperty("consultationDate")
    private Consultation consultation;

    @ManyToOne
    @JoinColumn(name="Emp_ID")
    @JsonProperty("empId")
    private Employee employee;

    public Integer getPrescriptionKey() {
        return prescriptionKey;
    }

    public void setPrescriptionKey(Integer prescriptionKey) {
        this.prescriptionKey = prescriptionKey;
    }

    public Integer getDosage() {
        return dosage;
    }

    public void setDosage(Integer dosage) {
        this.dosage = dosage;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public Medication getMedication() {
        return medication;
    }

    public void setMedication(Medication medication) {
        this.medication = medication;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Consultation getConsultation() {
        return consultation;
    }

    public void setConsultation(Consultation consultation) {
        this.consultation = consultation;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
