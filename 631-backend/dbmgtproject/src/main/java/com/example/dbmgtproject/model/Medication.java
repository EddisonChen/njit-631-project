package com.example.dbmgtproject.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import org.hibernate.annotations.Check;

@Entity
@Table(name="MEDICATION")
public class Medication {
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
