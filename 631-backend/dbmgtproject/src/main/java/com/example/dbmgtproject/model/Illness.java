package com.example.dbmgtproject.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="ILLNESS")
public class Illness implements Serializable {

    @OneToMany(mappedBy = "illness", cascade = CascadeType.ALL)
    @JsonProperty("diagnosisKey")
    private List<Diagnosis> diagnoses;
    @Id
    @Column(name="Illness_Code")
    private Integer illnessCode;

    @Column(name="Illness_Description")
    private String illnessDescription;

    public Integer getIllnessCode() {
        return illnessCode;
    }

    public void setIllnessCode(Integer illnessCode) {
        this.illnessCode = illnessCode;
    }

    public String getIllnessDescription() {
        return illnessDescription;
    }

    public void setIllnessDescription(String illnessDescription) {
        this.illnessDescription = illnessDescription;
    }
}
