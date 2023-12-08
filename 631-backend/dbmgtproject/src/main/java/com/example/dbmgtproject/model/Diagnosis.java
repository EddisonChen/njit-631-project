package com.example.dbmgtproject.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="DIAGNOSIS")
public class Diagnosis implements Serializable {
    @Id
    @Column(name="Diagnosis_Key")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer diagnosisKey;

    @Column(name="Comment")
    private String comment;

    @ManyToOne
    @JoinColumn(name="Illness_Code")
    @JsonProperty("illnessCode")
    private Illness illness;

    @ManyToOne
    @JoinColumn(name="Consultation_Date")
    @JsonProperty("consultationDate")
    private Consultation consultation;

    @ManyToOne
    @JoinColumn(name="Patient_Number")
    @JsonProperty("patientNumber")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name="Emp_ID")
    @JsonProperty("empId")
    private Employee employee;

    public Integer getDiagnosisKey() {
        return diagnosisKey;
    }

    public void setDiagnosisKey(Integer diagnosisKey) {
        this.diagnosisKey = diagnosisKey;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Illness getIllness() {
        return illness;
    }

    public void setIllness(Illness illness) {
        this.illness = illness;
    }

    public Consultation getConsultation() {
        return consultation;
    }

    public void setConsultation(Consultation consultation) {
        this.consultation = consultation;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
