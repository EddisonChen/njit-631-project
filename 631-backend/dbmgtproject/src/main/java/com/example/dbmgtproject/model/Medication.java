package com.example.dbmgtproject.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import org.hibernate.annotations.Check;

import java.io.Serializable;

@Entity
@Table(name="MEDICATION")
public class Medication implements Serializable {
    public Integer getMedication_code() {
        return medication_code;
    }

    public void setMedication_code(Integer medication_code) {
        this.medication_code = medication_code;
    }

    public Integer getYtd_usage() {
        return ytd_usage;
    }

    public void setYtd_usage(Integer ytd_usage) {
        this.ytd_usage = ytd_usage;
    }

    public String getMedication_name() {
        return medication_name;
    }

    public void setMedication_name(String medication_name) {
        this.medication_name = medication_name;
    }

    public Integer getQuantity_on_hand() {
        return quantity_on_hand;
    }

    public void setQuantity_on_hand(Integer quantity_on_hand) {
        this.quantity_on_hand = quantity_on_hand;
    }

    public Integer getQuantity_on_order() {
        return quantity_on_order;
    }

    public void setQuantity_on_order(Integer quantity_on_order) {
        this.quantity_on_order = quantity_on_order;
    }

    public Float getUnit_cost() {
        return unit_cost;
    }

    public void setUnit_cost(Float unit_cost) {
        this.unit_cost = unit_cost;
    }

    @Id
    @Column(name="Medication_Code")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer medication_code;

    @Column(name="YTD_Usage")
    private Integer ytd_usage;

    @Column(name="Medication_Name")
    private String medication_name;

    @Column(name="Quantity_On_Hand")
    private Integer quantity_on_hand;

    @Column(name="Quantity_On_Order")
    private Integer quantity_on_order;

    @Column(name="Unit_Cost")
    private Float unit_cost;
}
