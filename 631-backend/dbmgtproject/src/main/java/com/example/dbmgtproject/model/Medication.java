package com.example.dbmgtproject.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="MEDICATION")
public class Medication implements Serializable {

    @OneToMany(mappedBy = "medication1")
    @JsonProperty("reactsWithKey")
    private List<ReactsWith> reactsWithList;

    @OneToMany(mappedBy = "medication", cascade = CascadeType.ALL)
    @JsonProperty("makesKey")
    private List<Makes> makesList;
    @OneToMany(mappedBy = "medication", cascade = CascadeType.ALL)
    @JsonProperty("prescriptionKey")
    private List<Prescription> prescriptions;
    @Id
    @Column(name="Medication_Code")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer medicationCode;

    @Column(name="YTD_Usage")
    private Integer ytdUsage;

    @Column(name="Medication_Name")
    private String medicationName;

    @Column(name="Quantity_On_Hand")
    private Integer quantityOnHand;

    @Column(name="Quantity_On_Order")
    private Integer quantityOnOrder;

    @Column(name="Unit_Cost")
    private Float unitCost;

    public Integer getMedicationCode() {
        return medicationCode;
    }

    public void setMedicationCode(Integer medicationCode) {
        this.medicationCode = medicationCode;
    }

    public Integer getYtdUsage() {
        return ytdUsage;
    }

    public void setYtdUsage(Integer ytdUsage) {
        this.ytdUsage = ytdUsage;
    }

    public String getMedicationName() {
        return medicationName;
    }

    public void setMedicationName(String medicationName) {
        this.medicationName = medicationName;
    }

    public Integer getQuantityOnHand() {
        return quantityOnHand;
    }

    public void setQuantityOnHand(Integer quantityOnHand) {
        this.quantityOnHand = quantityOnHand;
    }

    public Integer getQuantityOnOrder() {
        return quantityOnOrder;
    }

    public void setQuantityOnOrder(Integer quantityOnOrder) {
        this.quantityOnOrder = quantityOnOrder;
    }

    public Float getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(Float unitCost) {
        this.unitCost = unitCost;
    }
}
