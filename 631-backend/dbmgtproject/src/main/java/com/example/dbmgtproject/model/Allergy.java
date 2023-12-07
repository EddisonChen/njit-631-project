package com.example.dbmgtproject.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="ALLERGY")
public class Allergy implements Serializable {
    public Integer getAllergy_code() {
        return allergy_code;
    }

    public void setAllergy_code(Integer allergy_code) {
        this.allergy_code = allergy_code;
    }

    public String getAllergy_description() {
        return allergy_description;
    }

    public void setAllergy_description(String allergy_description) {
        this.allergy_description = allergy_description;
    }

    @Id
    @Column(name="Allergy_Code")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer allergy_code;

    @Column(name="Allergy_Description")
    private String allergy_description;
}
