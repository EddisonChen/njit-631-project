package com.example.dbmgtproject.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="NURSE_SURGERY_TYPE")
public class NurseSurgeryType implements Serializable {

    @Id
    @Column(name="Nurse_Surgery_Type_Key")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer nurseSurgeryTypeKey;

    @ManyToOne
    @JoinColumn(name="Emp_ID")
    @JsonProperty("empId")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name="Surgery_Type_Code")
    @JsonProperty("surgeryType")
    private SurgeryType surgeryType;
    public Integer getNurseSurgeryTypeKey() {
        return nurseSurgeryTypeKey;
    }

    public void setNurseSurgeryTypeKey(Integer nurseSurgeryTypeKey) {
        this.nurseSurgeryTypeKey = nurseSurgeryTypeKey;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public SurgeryType getSurgeryType() {
        return surgeryType;
    }

    public void setSurgeryTypeCode(SurgeryType surgeryTypeCode) {
        this.surgeryType = surgeryType;
    }



}
