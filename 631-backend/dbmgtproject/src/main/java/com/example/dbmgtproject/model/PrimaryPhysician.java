package com.example.dbmgtproject.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="PRIMARY_PHYSICIAN")
public class PrimaryPhysician implements Serializable {
    @Id
    @Column(name="Primary_Physician_Key")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer primaryPhysicianKey;

    @ManyToOne
    @JoinColumn(name="Emp_ID")
    @JsonProperty("empId")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name="Patient_Number")
    @JsonProperty("patientNumber")
    private Patient patient;

    public Integer getPrimaryPhysicianKey() {
        return primaryPhysicianKey;
    }

    public void setPrimaryPhysicianKey(Integer primaryPhysicianKey) {
        this.primaryPhysicianKey = primaryPhysicianKey;
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
