package com.example.dbmgtproject.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name="NURSE_CARES_FOR")
public class NurseCaresFor implements Serializable {
    @Id
    @Column(name="Nurse_Cares_For_Key")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer nurseCaresForKey;

    @Column(name="Shift")
    private Integer shift;

    @Column(name="date")
    private Date date;

    @ManyToOne
    @JoinColumn(name="Emp_ID")
    @JsonProperty("empId")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name="Patient_Number")
    @JsonProperty("patientNumber")
    private Patient patient;

    public Integer getNurseCaresForKey() {
        return nurseCaresForKey;
    }

    public void setNurseCaresForKey(Integer nurseCaresForKey) {
        this.nurseCaresForKey = nurseCaresForKey;
    }

    public Integer getShift() {
        return shift;
    }

    public void setShift(Integer shift) {
        this.shift = shift;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
