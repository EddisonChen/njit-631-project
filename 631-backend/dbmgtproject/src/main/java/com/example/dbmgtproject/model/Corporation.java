package com.example.dbmgtproject.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import org.hibernate.annotations.Check;

@Entity
@Table(name="CORPORATION")
public class Corporation {
    @Id
    @Column(name="Corp_Name")
    private String corp_name;

    @Column(name="Percent_Ownership", columnDefinition="INT CHECK (Percent_Ownership <=100)")
    private Integer percent_ownership;

    @Column(name="HeadQuarters")
    private String headquarters;

}
