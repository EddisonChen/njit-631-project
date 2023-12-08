package com.example.dbmgtproject.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="SURGERY_SKILL")
public class SurgerySkill implements Serializable {

    @OneToMany(mappedBy = "surgerySkill", cascade = CascadeType.ALL)
    @JsonProperty("requiresKey")
    private List<Requires> requiresList;

    @OneToMany(mappedBy = "surgerySkill", cascade = CascadeType.ALL)
    @JsonProperty("hasSkillsKey")
    private List<HasSkills> hasSkillsList;
    @Id
    @Column(name="Skill_Code")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer skillCode;

    @Column(name="Description")
    private String description;

    public Integer getSkillCode() {
        return skillCode;
    }

    public void setSkillCode(Integer skillCode) {
        this.skillCode = skillCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
