package com.example.dbmgtproject.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import org.hibernate.annotations.Check;

import java.io.Serializable;

@Entity
@Table(name="CLINIC_BED")
public class Clinic_Bed implements Serializable {
    @Id
    @Column(name="Bed_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bed_id;

    @Column(name="Bed_Letter")
    @Pattern(regexp="[AB]", message="bed_letter must be A or B")
    private Character bed_letter;

    public Integer getBed_id() {
        return bed_id;
    }

    public void setBed_id(Integer bed_id) {
        this.bed_id = bed_id;
    }

    public Character getBed_letter() {
        return bed_letter;
    }

    public void setBed_letter(Character bed_letter) {
        this.bed_letter = bed_letter;
    }

    public Integer getRoom_Number() {
        return room_Number;
    }

    public void setRoom_Number(Integer room_Number) {
        this.room_Number = room_Number;
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

    @Column(name="Room_Number")
    private Integer room_Number;

    @Column(name="Wing")
    @Check(constraints="Wing IN ('Blue', 'Green')")
    private String wing;

    @Column(name="Unit", columnDefinition="INT CHECK (Unit >=1 AND Unit <=7)")
    private Integer unit;


}
