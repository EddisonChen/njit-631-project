package com.example.dbmgtproject.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name="ADMITTED_TO")
public class AdmittedTo implements Serializable {
    @Id
    @Column(name="Admitted_To_Key")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer admittedToKey;

    @Column(name="Duration")
    private Integer duration;

    @Column(name="Date")
    private Date date;

    @ManyToOne
    @JoinColumn(name="Patient_Number")
    @JsonProperty("patientNumber")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name="Bed_ID")
    @JsonProperty("bedId")
    private ClinicBed clinicBed;

    public Integer getAdmittedToKey() {
        return admittedToKey;
    }

    public void setAdmittedToKey(Integer admittedToKey) {
        this.admittedToKey = admittedToKey;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
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

    public ClinicBed getClinicBed() {
        return clinicBed;
    }

    public void setClinicBed(ClinicBed clinicBed) {
        this.clinicBed = clinicBed;
    }
}
