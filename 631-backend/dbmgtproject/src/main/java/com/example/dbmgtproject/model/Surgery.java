package com.example.dbmgtproject.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name="Surgery")
public class Surgery implements Serializable {
    @Id
    @Column(name="Surgery_Key")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer surgeryKey;

    @Column(name="Theater")
    private String theater;

    @Column(name="Date")
    private Date date;

    @ManyToMany
    @JoinColumn(name="Emp_ID")
    @JsonProperty("empId")
    private List<Employee> employees;

    @ManyToOne
    @JoinColumn(name="Surgery_Type_Code")
    @JsonProperty("surgeryType")
    private SurgeryType surgeryType;

    @ManyToOne
    @JoinColumn(name="Patient_Number")
    @JsonProperty("patientNumber")
    private Patient patient;

    public Integer getSurgeryKey() {
        return surgeryKey;
    }

    public void setSurgeryKey(Integer surgeryKey) {
        this.surgeryKey = surgeryKey;
    }

    public String getTheater() {
        return theater;
    }

    public void setTheater(String theater) {
        this.theater = theater;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public SurgeryType getSurgeryType() {
        return surgeryType;
    }

    public void setSurgeryType(SurgeryType surgeryType) {
        this.surgeryType = surgeryType;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
