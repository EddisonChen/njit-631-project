package com.example.dbmgtproject.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import org.hibernate.annotations.Check;

@Entity
@Table(name="CLINIC_BED")
public class Clinic_Bed {
    @Id
    @Column(name="Bed_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bed_id;

    @Column(name="Bed_Letter")
    @Pattern(regexp="[AB]", message="bed_letter must be A or B")
    private Character bed_letter;

    @Column(name="Room_Number")
    private Integer room_Number;

    @Column(name="Wing")
    @Check(constraints="Wing IN ('Blue', 'Green')")
    private String wing;

    @Column(name="Unit", columnDefinition="INT CHECK (Unit >=1 AND Unit <=7)")
    private Integer unit;


}
