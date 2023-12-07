package com.example.dbmgtproject.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import org.hibernate.annotations.Check;

import java.sql.Date;

@Entity
@Table(name="SURGERY")
@IdClass(SurgeryPK.class)
public class Surgery {
    @Id
    @ManyToOne
    @JoinColumn(name="Emp_ID")
    private Employee employee;

    @Id
    @ManyToOne
    @JoinColumn(name="Patient_Number")
    private Patient patient;

    @Id
    @ManyToOne
    @JoinColumn(name="Surgery_Type_Code")
    private Surgery_Type surgery_type;

    @Id
    @Column(name="Date")
    private Date date;

    @Column(name="Theater")
    private String theater;
}
