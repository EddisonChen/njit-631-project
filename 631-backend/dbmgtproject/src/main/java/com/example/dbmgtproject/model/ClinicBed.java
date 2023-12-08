package com.example.dbmgtproject.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import org.hibernate.annotations.Check;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="CLINIC_BED")
public class ClinicBed implements Serializable {
    @OneToMany(mappedBy = "clinicBed", cascade = CascadeType.ALL)
    @JsonProperty("admittedToKey")
    private List<AdmittedTo> admittedToList;

    @Id
    @Column(name="Bed_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bedId;

    @Column(name="Bed_Letter", columnDefinition = "CHAR CHECK (Bed_Letter IN ('A', 'B'))")
    private Character bedLetter;

    @Column(name="Room_Number")
    private Integer roomNumber;

    @Column(name="Wing", columnDefinition = "CHAR CHECK (Wing IN ('Blue', 'Green'))")
    private String wing;

    @Column(name="Unit")
    @Check(constraints= "Unit>= 1 AND Unit <= 7")
    private Integer unit;

    public Integer getBedId() {
        return bedId;
    }

    public void setBedId(Integer bedId) {
        this.bedId = bedId;
    }

    public Character getBedLetter() {
        return bedLetter;
    }

    public void setBedLetter(Character bedLetter) {
        this.bedLetter = bedLetter;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getWing() {
        return wing;
    }

    public void setWing(String wing) {
        this.wing = wing;
    }

    public Integer getUnit() {
        return unit;
    }

    public void setUnit(Integer unit) {
        this.unit = unit;
    }
}
