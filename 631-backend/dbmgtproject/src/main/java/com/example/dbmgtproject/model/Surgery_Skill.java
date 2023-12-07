package com.example.dbmgtproject.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import org.hibernate.annotations.Check;

@Entity
@Table(name="SURGERY_SKILL")
public class Surgery_Skill {
    @Id
    @Column(name="Skill_Code")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer skill_code;

    @Column(name="Description")
    private String description;
}
