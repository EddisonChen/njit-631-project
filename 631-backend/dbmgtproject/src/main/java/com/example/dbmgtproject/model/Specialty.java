package com.example.dbmgtproject.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="Specialty")
public class Specialty implements Serializable {
    @Id
    @Column(name="Specialty_Key")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer specialtyKey;

    @OneToMany(mappedBy="specialty")
    @JsonProperty("empId")
    private List<Employee> employees;

    @OneToMany(mappedBy="specialty")
    @JsonProperty("surgeryTypeCode")
    private List<SurgeryType> surgeryTypes;

    public Integer getSpecialtyKey() {
        return specialtyKey;
    }

    public void setSpecialtyKey(Integer specialtyKey) {
        this.specialtyKey = specialtyKey;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<SurgeryType> getSurgeryTypes() {
        return surgeryTypes;
    }

    public void setSurgeryTypes(List<SurgeryType> surgeryTypes) {
        this.surgeryTypes = surgeryTypes;
    }
}
