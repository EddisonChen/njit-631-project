package com.example.dbmgtproject.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
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
    @JoinTable(
            name = "employee_surgery",
            joinColumns = @JoinColumn(name = "Surgery_Key"),
            inverseJoinColumns = @JoinColumn(name = "Emp_ID")
    )
    @JsonProperty("empId")
    private List<Employee> employees;

    @ManyToOne
    @JoinColumn(name="Surgery_Type_Code")
    @JsonProperty("surgeryKey")
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

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
