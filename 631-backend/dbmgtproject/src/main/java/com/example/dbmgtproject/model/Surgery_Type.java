package com.example.dbmgtproject.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import org.hibernate.annotations.Check;

import java.util.List;

@Entity
@Table(name="SURGERY_TYPE")
public class Surgery_Type {
    @Id
    @Column(name="Surgery_Type_Code")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer surgery_type_code;

    @Column(name="Surgery_Name")
    private String surgery_name;

    @Column(name="Anatomical_Location")
    private String anatomical_location;

    @Column(name="Surgery_Category")
    @Pattern(regexp="[H0]", message="bed_letter must be H or 0")
    private Character surgery_category;

    @OneToMany(mappedBy="surgery_type", cascade = CascadeType.ALL)
    private List<Surgery> surgeries;
}
