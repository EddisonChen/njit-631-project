package com.example.dbmgtproject.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="ALLERGY")
public class Allergy implements Serializable {

    @OneToMany(mappedBy = "allergy", cascade = CascadeType.ALL)
    @JsonProperty("hasAllergyKey")
    private List<HasAllergy> hasAllergies;
    @Id
    @Column(name="Allergy_Code")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer allergyCode;

    @Column(name="Allergy_Description")
    private String allergyDescription;

    public Integer getAllergyCode() {
        return allergyCode;
    }

    public void setAllergyCode(Integer allergyCode) {
        this.allergyCode = allergyCode;
    }

    public String getAllergyDescription() {
        return allergyDescription;
    }

    public void setAllergyDescription(String allergyDescription) {
        this.allergyDescription = allergyDescription;
    }
}
