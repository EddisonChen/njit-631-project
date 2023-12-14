package com.example.dbmgtproject.repository;

import com.example.dbmgtproject.model.Employee;
import com.example.dbmgtproject.model.Patient;
import com.example.dbmgtproject.model.Surgery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface SurgeryRepository extends JpaRepository<Surgery, Integer> {
    List<Surgery> findSurgeriesByEmployeesEmpIdAndDate(Integer surgeonId, Date date);

    @Query("SELECT s.surgeryKey, s.patient.patientNumber FROM Surgery s WHERE s.theater = :theater AND s.date = :date")
    List<Object[]> findSurgeryByTheaterAndDate(@Param("theater") String theater, @Param("date") Date date);

    @Query("SELECT s.surgeryKey, s.date, s.theater FROM Surgery s WHERE s.patient.patientNumber = :patientNumber")
    List<Object[]> findSurgeriesByPatientPatientNumber(Integer patientNumber);

}
