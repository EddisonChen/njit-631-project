package com.example.dbmgtproject.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import org.hibernate.annotations.Check;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="EMPLOYEE")
public class Employee implements Serializable {
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    @JsonProperty("hasSkillsKey")
    private List<HasSkills> hasSkillsList;
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    @JsonProperty("physicianCaresForKey")
    private List<PhysicianCaresFor> physicianCaresForList;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="Specialty")
    @JsonProperty("specialtyKey")
    private Specialty specialty;
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    @JsonProperty("diagnosisKey")
    private List<Diagnosis> diagnoses;
    @OneToMany(mappedBy="employee", cascade = CascadeType.ALL)
    @JsonProperty("prescriptionKey")
    private List<Prescription> prescriptions;
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    @JsonProperty("consultationKey")
    private List<Consultation> consultations;
    @ManyToMany(mappedBy="employees", cascade = CascadeType.ALL)
    @JsonProperty("surgeryKey")
    private List<Surgery> surgeries;
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    @JsonProperty("nurseCaresForKey")
    private List<NurseCaresFor> nurseCaresForList;
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    @JsonProperty("primaryPhysicianKey")
    private List<PrimaryPhysician> primaryPhysicians;
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    @JsonProperty("nurseSurgeryTypeKey")
    private List<NurseSurgeryType> nurseSurgeryTypes;
    @Id
    @Column(name="Emp_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer empId;

    @Column(name="Name")
    private String name;

    @Column(name="Salary")
    @Check(constraints= "Salary IS NULL OR (Salary BETWEEN 25000 AND 300000)")
    private Integer salary;

    @Column(name="Gender", columnDefinition = "CHAR CHECK (Gender IN('M', 'F'))")
    private Character gender;

    @Column(name="Address")
    private String address;

    @Column(name="SSN")
    private String ssn;

    @Column(name="Phone")
    private String phone;

    @Column(name="Emp_Type")
    private String empType;

    @Column(name="Support_Staff_Type")
    private String supportStaffType;

    @Column(name="Grade")
    private String grade;

    @Column(name="Years_Experience")
    private Integer yearsExperience;

    @Column(name="Doc_Type")
    private String docType;

    @Column(name="Amount")
    private Integer amount;

    @Column(name="Contract_Type")
    private String contractType;

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
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

    public String getEmpType() {
        return empType;
    }

    public void setEmpType(String empType) {
        this.empType = empType;
    }

    public String getSupportStaffType() {
        return supportStaffType;
    }

    public void setSupportStaffType(String supportStaffType) {
        this.supportStaffType = supportStaffType;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Integer getYearsExperience() {
        return yearsExperience;
    }

    public void setYearsExperience(Integer yearsExperience) {
        this.yearsExperience = yearsExperience;
    }

    public Specialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getContractType() {
        return contractType;
    }

    public void setContractType(String contractType) {
        this.contractType = contractType;
    }
}
