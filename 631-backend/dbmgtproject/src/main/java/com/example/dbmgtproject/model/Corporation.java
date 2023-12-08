package com.example.dbmgtproject.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import org.hibernate.annotations.Check;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="CORPORATION")
public class Corporation implements Serializable {

    @OneToMany(mappedBy = "corporation", cascade = CascadeType.ALL)
    @JsonProperty("makes")
    private List<Makes> makesList;
    @Id
    @Column(name="Corp_Name")
    private String corpName;

    @Column(name="Percent_Ownership")
    @Check(constraints= "Percent_Ownership <= 100")
    private Integer percentOwnership;

    @Column(name="Headquarters")
    private String headquarters;

    public String getCorpName() {
        return corpName;
    }

    public void setCorpName(String corpName) {
        this.corpName = corpName;
    }

    public Integer getPercentOwnership() {
        return percentOwnership;
    }

    public void setPercentOwnership(Integer percentOwnership) {
        this.percentOwnership = percentOwnership;
    }

    public String getHeadquarters() {
        return headquarters;
    }

    public void setHeadquarters(String headquarters) {
        this.headquarters = headquarters;
    }
}
