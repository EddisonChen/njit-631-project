package com.example.dbmgtproject.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="PHYSICIAN_CARES_FOR")
public class PhysicianCaresFor implements Serializable {
    @Id
    @Column(name="Physician_Cares_For_Key")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer physicianCaresForKey;

    @ManyToOne
    @JoinColumn(name="Emp_ID")
    @JsonProperty("empId")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name="Patient_Number")
    @JsonProperty("patientNumber")
    private Patient patient;

    public Integer getPhysicianCaresForKey() {
        return physicianCaresForKey;
    }

    public void setPhysicianCaresForKey(Integer physicianCaresForKey) {
        this.physicianCaresForKey = physicianCaresForKey;
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
