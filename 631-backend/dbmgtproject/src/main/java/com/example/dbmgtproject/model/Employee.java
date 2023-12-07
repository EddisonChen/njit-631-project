package com.example.dbmgtproject.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import org.hibernate.annotations.Check;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="EMPLOYEE")
public class Employee implements Serializable {
    public Integer getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(Integer emp_id) {
        this.emp_id = emp_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmp_type() {
        return emp_type;
    }

    public void setEmp_type(String emp_type) {
        this.emp_type = emp_type;
    }

    public String getSupport_staff_type() {
        return support_staff_type;
    }

    public void setSupport_staff_type(String support_staff_type) {
        this.support_staff_type = support_staff_type;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Integer getYears_experience() {
        return years_experience;
    }

    public void setYears_experience(Integer years_experience) {
        this.years_experience = years_experience;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getDoc_type() {
        return doc_type;
    }

    public void setDoc_type(String doc_type) {
        this.doc_type = doc_type;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getContract_type() {
        return contract_type;
    }

    public void setContract_type(String contract_type) {
        this.contract_type = contract_type;
    }

    public List<Surgery> getSurgeries() {
        return surgeries;
    }

    public void setSurgeries(List<Surgery> surgeries) {
        this.surgeries = surgeries;
    }

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

    @OneToMany(mappedBy="employee", cascade = CascadeType.ALL)
    private List<Surgery> surgeries;
}
