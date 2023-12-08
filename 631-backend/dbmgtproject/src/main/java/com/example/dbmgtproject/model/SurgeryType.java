package com.example.dbmgtproject.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="SURGERY_TYPE")
public class SurgeryType implements Serializable {

    @OneToMany(mappedBy = "surgeryType", cascade = CascadeType.ALL)
    @JsonProperty("requiresKey")
    private List<Requires> requiresList;
    @ManyToOne(cascade = CascadeType.ALL)
    @JsonProperty("specialtyKey")
    private Specialty specialty;
    @OneToMany(mappedBy = "surgeryType", cascade = CascadeType.ALL)
    @JsonProperty("surgeryKey")
    private List<Surgery> surgeries;

    @OneToMany(mappedBy = "surgeryType", cascade = CascadeType.ALL)
    @JsonProperty("nurseSurgeryTypeKey")
    private List<NurseSurgeryType> nurseSurgeryTypes;

    @Id
    @Column(name="Surgery_Type_Code")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer surgeryTypeCode;

    @Column(name="Surgery_Name")
    private String surgeryName;

    @Column(name="Anatomical_Location")
    private String anatomicalLocation;

    @Column(name="Surgery_Category", columnDefinition = "CHAR CHECK (Surgery_Category IN ('H', '0'))")
    private Character surgeryCategory;

    @Column(name="Special_Needs")
    private String specialNeeds;

    public Integer getSurgeryTypeCode() {
        return surgeryTypeCode;
    }

    public void setSurgeryTypeCode(Integer surgeryTypeCode) {
        this.surgeryTypeCode = surgeryTypeCode;
    }

    public String getSurgeryName() {
        return surgeryName;
    }

    public void setSurgeryName(String surgeryName) {
        this.surgeryName = surgeryName;
    }

    public String getAnatomicalLocation() {
        return anatomicalLocation;
    }

    public void setAnatomicalLocation(String anatomicalLocation) {
        this.anatomicalLocation = anatomicalLocation;
    }

    public Character getSurgeryCategory() {
        return surgeryCategory;
    }

    public void setSurgeryCategory(Character surgeryCategory) {
        this.surgeryCategory = surgeryCategory;
    }

    public String getSpecialNeeds() {
        return specialNeeds;
    }

    public void setSpecialNeeds(String specialNeeds) {
        this.specialNeeds = specialNeeds;
    }


}
