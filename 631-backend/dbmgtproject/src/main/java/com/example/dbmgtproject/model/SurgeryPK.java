package com.example.dbmgtproject.model;

import java.sql.Date;
import java.util.Objects;

public class SurgeryPK {
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
