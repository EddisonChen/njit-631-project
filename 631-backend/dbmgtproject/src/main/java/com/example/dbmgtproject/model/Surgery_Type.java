package com.example.dbmgtproject.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import org.hibernate.annotations.Check;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="SURGERY_TYPE")
public class Surgery_Type implements Serializable {
    @Id
    @Column(name="Surgery_Type_Code")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer surgery_type_code;

    @Column(name="Surgery_Name")
    private String surgery_name;

    public Integer getSurgery_type_code() {
        return surgery_type_code;
    }

    public void setSurgery_type_code(Integer surgery_type_code) {
        this.surgery_type_code = surgery_type_code;
    }

    public String getSurgery_name() {
        return surgery_name;
    }

    public void setSurgery_name(String surgery_name) {
        this.surgery_name = surgery_name;
    }

    public String getAnatomical_location() {
        return anatomical_location;
    }

    public void setAnatomical_location(String anatomical_location) {
        this.anatomical_location = anatomical_location;
    }

    public Character getSurgery_category() {
        return surgery_category;
    }

    public void setSurgery_category(Character surgery_category) {
        this.surgery_category = surgery_category;
    }

    public List<Surgery> getSurgeries() {
        return surgeries;
    }

    public void setSurgeries(List<Surgery> surgeries) {
        this.surgeries = surgeries;
    }

    @Column(name="Anatomical_Location")
    private String anatomical_location;

    @Column(name="Surgery_Category")
    @Pattern(regexp="[H0]", message="bed_letter must be H or 0")
    private Character surgery_category;

    @OneToMany(mappedBy="surgery_type", cascade = CascadeType.ALL)
    private List<Surgery> surgeries;
}
