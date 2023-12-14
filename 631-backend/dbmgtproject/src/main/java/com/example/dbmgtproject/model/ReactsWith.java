package com.example.dbmgtproject.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="REACTS_WITH")
public class ReactsWith implements Serializable {
    @Id
    @Column(name="Reacts_With_Key")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer reactsWithKey;

    @Column(name="Severity", columnDefinition = "CHAR CHECK (Gender IN('S', 'M', 'L', 'N'))")
    private Character severity;

    @ManyToOne
    @JoinColumn(name = "Medication_Code1")
    @JsonProperty("medicationCode1")
    private Medication medication1;

    @ManyToOne
    @JoinColumn(name = "Medication_Code2")
    @JsonProperty("medicationCode2")
    private Medication medication2;

}
