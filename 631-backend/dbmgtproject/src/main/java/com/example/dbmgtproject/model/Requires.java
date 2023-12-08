package com.example.dbmgtproject.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="REQUIRES")
public class Requires implements Serializable {
    @Id
    @Column(name="Requires_Key")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer requiresKey;

    @ManyToOne
    @JoinColumn(name="Surgery_Type_Code")
    @JsonProperty("surgeryTypeCode")
    private SurgeryType surgeryType;

    @ManyToOne
    @JoinColumn(name="Skill_Code")
    @JsonProperty("skillCode")
    private SurgerySkill surgerySkill;

    public Integer getRequiresKey() {
        return requiresKey;
    }

    public void setRequiresKey(Integer requiresKey) {
        this.requiresKey = requiresKey;
    }

    public SurgeryType getSurgeryType() {
        return surgeryType;
    }

    public void setSurgeryType(SurgeryType surgeryType) {
        this.surgeryType = surgeryType;
    }

    public SurgerySkill getSurgerySkill() {
        return surgerySkill;
    }

    public void setSurgerySkill(SurgerySkill surgerySkill) {
        this.surgerySkill = surgerySkill;
    }
}
