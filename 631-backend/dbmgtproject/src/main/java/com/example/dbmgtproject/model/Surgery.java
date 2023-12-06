package com.example.dbmgtproject.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import org.hibernate.annotations.Check;

import java.sql.Date;

@Entity
@Table(name="SURGERY")
public class Surgery {
    @Column(name="Emp_ID")
    private Integer emp_id;

    @Column(name="Patient_Number")
    private Integer patient_number;

    @Column(name="Surgery_Type_Code")
    private Integer surgery_type_code;

    @Column(name="Date")
    private Date date;

    @Column(name="Theater")
    private String theater;


}
