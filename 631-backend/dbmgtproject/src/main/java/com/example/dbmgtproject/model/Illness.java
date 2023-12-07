package com.example.dbmgtproject.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import org.hibernate.annotations.Check;

import java.io.Serializable;

@Entity
@Table(name="ILLNESS")
public class Illness implements Serializable {
    public Integer getIllness_code() {
        return illness_code;
    }

    public void setIllness_code(Integer illness_code) {
        this.illness_code = illness_code;
    }

    public String getIllness_description() {
        return illness_description;
    }

    public void setIllness_description(String illness_description) {
        this.illness_description = illness_description;
    }

    @Id
    @Column(name="Illness_Code")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer illness_code;

    @Column(name="Illness_Description")
    private String illness_description;

}
