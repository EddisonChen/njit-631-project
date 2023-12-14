package com.example.dbmgtproject.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="CONSULTATION")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "consultationKey")
public class Consultation implements Serializable {
    @OneToMany(mappedBy = "consultation")
    @JsonProperty("diagnosisKey")
    private List<Diagnosis> diagnoses;
    @OneToMany(mappedBy = "consultation")
    @JsonProperty("prescriptionKey")
    private List<Prescription> prescription;
    @Id
    @Column(name="Consultation_Key")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer consultationKey;

    @Column(name="Consultation_Date")
    private Date consultationDate;

    @Column(name="Type")
    private String type;

    @Column(name="Notes")
    private String notes;

    @ManyToOne
    @JoinColumn(name="Patient_Number")
    @JsonProperty("patientNumber")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name="Emp_ID")
    @JsonProperty("empId")
    @JsonIgnore
    private Employee employee;

    public Integer getConsultationKey() {
        return consultationKey;
    }

    public void setConsultationKey(Integer consultationKey) {
        this.consultationKey = consultationKey;
    }

    public Date getConsultationDate() {
        return consultationDate;
    }

    public void setConsultationDate(Date consultationDate) {
        this.consultationDate = consultationDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
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
