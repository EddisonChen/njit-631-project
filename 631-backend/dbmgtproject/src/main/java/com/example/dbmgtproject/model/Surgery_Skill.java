package com.example.dbmgtproject.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import org.hibernate.annotations.Check;

import java.io.Serializable;

@Entity
@Table(name="SURGERY_SKILL")
public class Surgery_Skill implements Serializable {
    public Integer getSkill_code() {
        return skill_code;
    }

    public void setSkill_code(Integer skill_code) {
        this.skill_code = skill_code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Id
    @Column(name="Skill_Code")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer skill_code;

    @Column(name="Description")
    private String description;
}
