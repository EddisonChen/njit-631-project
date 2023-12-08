package com.example.dbmgtproject.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="HAS_ALLERGY")
public class HasAllergy implements Serializable {
    @Id
    @Column(name="Has_Allergy_Key")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer hasAllergyKey;

    @ManyToOne
    @JoinColumn(name="Patient_Number")
    @JsonProperty("patientNumber")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name="Allergy_Code")
    @JsonProperty("allergyCode")
    private Allergy allergy;

    public Integer getHasAllergyKey() {
        return hasAllergyKey;
    }

    public void setHasAllergyKey(Integer hasAllergyKey) {
        this.hasAllergyKey = hasAllergyKey;
    }
}
