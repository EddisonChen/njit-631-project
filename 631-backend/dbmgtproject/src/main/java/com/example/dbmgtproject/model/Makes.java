package com.example.dbmgtproject.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="MAKES")
public class Makes implements Serializable {
    @Id
    @Column(name="Makes_Key")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer makesKey;

    @ManyToOne
    @JoinColumn(name="Corp_Name")
    @JsonProperty("corpName")
    private Corporation corporation;

    @ManyToOne
    @JoinColumn(name="Medication_Code")
    @JsonProperty("medicationCode")
    private Medication medication;

    public Integer getMakesKey() {
        return makesKey;
    }

    public void setMakesKey(Integer makesKey) {
        this.makesKey = makesKey;
    }

    public Corporation getCorporation() {
        return corporation;
    }

    public void setCorporation(Corporation corporation) {
        this.corporation = corporation;
    }

    public Medication getMedication() {
        return medication;
    }

    public void setMedication(Medication medication) {
        this.medication = medication;
    }
}
