package com.example.dbmgtproject.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import org.hibernate.annotations.Check;

@Entity
@Table(name="ILLNESS")
public class Illness {
    @Id
    @Column(name="Illness_Code")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer illness_code;

    @Column(name="Illness_Description")
    private String illness_description;

}
