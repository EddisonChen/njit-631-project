package com.example.dbmgtproject.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import org.hibernate.annotations.Check;

import java.io.Serializable;

@Entity
@Table(name="CORPORATION")
public class Corporation implements Serializable {
    public String getCorp_name() {
        return corp_name;
    }

    public void setCorp_name(String corp_name) {
        this.corp_name = corp_name;
    }

    public Integer getPercent_ownership() {
        return percent_ownership;
    }

    public void setPercent_ownership(Integer percent_ownership) {
        this.percent_ownership = percent_ownership;
    }

    public String getHeadquarters() {
        return headquarters;
    }

    public void setHeadquarters(String headquarters) {
        this.headquarters = headquarters;
    }

    @Id
    @Column(name="Corp_Name")
    private String corp_name;

    @Column(name="Percent_Ownership", columnDefinition="INT CHECK (Percent_Ownership <=100)")
    private Integer percent_ownership;

    @Column(name="HeadQuarters")
    private String headquarters;

}
