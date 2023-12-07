package com.example.dbmgtproject.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import org.hibernate.annotations.Check;

import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name="SURGERY")
@IdClass(SurgeryPK.class)
public class Surgery implements Serializable {
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

    public Surgery_Type getSurgery_type() {
        return surgery_type;
    }

    public void setSurgery_type(Surgery_Type surgery_type) {
        this.surgery_type = surgery_type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTheater() {
        return theater;
    }

    public void setTheater(String theater) {
        this.theater = theater;
    }

    @Id
    @ManyToOne
    @JoinColumn(name="Emp_ID")
    @JsonIgnoreProperties({"name", "salary", "gender", "address", "ssn", "phone", "emp_type", "support_staff_type", "grade", "years_experience", "specialty", "doc_type", "duration", "amount", "contract_type", "surgeries"})
    private Employee employee;

    @Id
    @ManyToOne
    @JoinColumn(name="Patient_Number")
    @JsonIgnoreProperties({"ssn", "blood_type", "address", "name", "gender", "surgeries"})
    private Patient patient;

    @Id
    @ManyToOne
    @JoinColumn(name="Surgery_Type_Code")
    @JsonIgnoreProperties({"surgery_name", "anatomical_location", "surgery_category", "surgeries"})
    private Surgery_Type surgery_type;

    @Id
    @Column(name="Date")
    private Date date;

    @Column(name="Theater")
    private String theater;
}
