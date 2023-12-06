package com.example.dbmgtproject.model;

import jakarta.persistence.*;

@Entity
@Table(name="ALLERGY")
public class Allergy {
    @Id
    @Column(name="Allergy_Code")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer allergy_code;

    @Column(name="Allergy_Description")
    private String allergy_description;
}
