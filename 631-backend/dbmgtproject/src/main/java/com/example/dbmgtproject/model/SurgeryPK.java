package com.example.dbmgtproject.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

public class SurgeryPK implements Serializable {
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Surgery_Type getSurgeryType() {
        return surgeryType;
    }

    public void setSurgeryType(Surgery_Type surgeryType) {
        this.surgeryType = surgeryType;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    private Employee employee;
    private Patient patient;
    private Surgery_Type surgeryType;
    private Date date;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SurgeryPK surgeryPK = (SurgeryPK) o;
        return Objects.equals(employee, surgeryPK.employee) &&
                Objects.equals(patient, surgeryPK.patient) &&
                Objects.equals(surgeryType, surgeryPK.surgeryType) &&
                Objects.equals(date, surgeryPK.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employee, patient, surgeryType, date);
    }
}
