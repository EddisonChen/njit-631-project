package com.example.dbmgtproject.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import java.io.Serializable;
@Entity
@Table(name="HAS_SKILLS")
public class HasSkills implements Serializable {
    @Id
    @Column(name="Has_Skills_Key")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer hasSkillsKey;

    @ManyToOne
    @JoinColumn(name="Emp_ID")
    @JsonProperty("empId")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name="Skill_Code")
    @JsonProperty("skillCode")
    private SurgerySkill surgerySkill;

    public Integer getHasSkillsKey() {
        return hasSkillsKey;
    }

    public void setHasSkillsKey(Integer hasSkillsKey) {
        this.hasSkillsKey = hasSkillsKey;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public SurgerySkill getSurgerySkill() {
        return surgerySkill;
    }

    public void setSurgerySkill(SurgerySkill surgerySkill) {
        this.surgerySkill = surgerySkill;
    }
}
