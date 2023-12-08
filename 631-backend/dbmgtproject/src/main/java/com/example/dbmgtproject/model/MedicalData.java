package com.example.dbmgtproject.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name="MEDICAL_DATA")
public class MedicalData implements Serializable {
    @Id
    @Column(name="Medical_Data_Key")
    private Integer medicalDataKey;

    @Column(name="Blood_Sugar")
    private Integer bloodSugar;

    @Column(name="HDL")
    private Integer hdl;

    @Column(name="LDL")
    private Integer ldl;

    @Column(name="Triglyceride")
    private Integer triglyceride;

    @Column(name="Date")
    private Date date;

    @OneToOne
    @JoinColumn(name="Patient_Number")
    @JsonProperty("patientNumber")
    private Patient patient;

    public Integer getMedicalDataKey() {
        return medicalDataKey;
    }

    public void setMedicalDataKey(Integer medicalDataKey) {
        this.medicalDataKey = medicalDataKey;
    }

    public Integer getBloodSugar() {
        return bloodSugar;
    }

    public void setBloodSugar(Integer bloodSugar) {
        this.bloodSugar = bloodSugar;
    }

    public Integer getHdl() {
        return hdl;
    }

    public void setHdl(Integer hdl) {
        this.hdl = hdl;
    }

    public Integer getLdl() {
        return ldl;
    }

    public void setLdl(Integer ldl) {
        this.ldl = ldl;
    }

    public Integer getTriglyceride() {
        return triglyceride;
    }

    public void setTriglyceride(Integer triglyceride) {
        this.triglyceride = triglyceride;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
