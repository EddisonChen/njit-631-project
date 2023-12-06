package com.example.dbmgtproject.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import org.hibernate.annotations.Check;

@Entity
@Table(name="EMPLOYEE")
public class Employee {
    @Id
    @Column(name="Emp_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer emp_id;

    @Column(name="Name")
    private String name;

    @Column(name="Salary", columnDefinition = "INT CHECK (Salary IS NULL OR (Salary >= 25000 AND Salary <= 300000))")
    private Integer salary;

    @Column(name = "Gender", columnDefinition = "CHAR CHECK (Gender IN ('M', 'F'))")
    private Character gender;

    @Column(name="Address")
    private String address;

    @Column(name="SSN")
    private String ssn;

    @Column(name="Phone")
    private String phone;

    @Column(name="Emp_Type")
    private String emp_type;

    @Column(name="Support_Staff_Type")
    private String support_staff_type;

    @Column(name="Grade")
    private String grade;

    @Column(name="Years_Experience")
    private Integer years_experience;

    @Column(name="Specialty")
    private String specialty;

    @Column(name="Doc_Type")
    private String doc_type;

    @Column(name="Duration")
    private Integer duration;

    @Column(name="Amount")
    private Integer amount;

    @Column(name="Contract_Type")
    private String contract_type;
}
