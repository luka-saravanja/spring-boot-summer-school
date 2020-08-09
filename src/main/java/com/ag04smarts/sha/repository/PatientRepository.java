package com.ag04smarts.sha.repository;

import java.util.List;
import java.util.Optional;


import com.ag04smarts.sha.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    @Query(value = " SELECT * FROM PATIENT p WHERE p.age > 21 AND p.enlistment_date >= '2020-01-01' ", nativeQuery = true)
    List<Patient> findAllPatientsOlderThan21AndEnlistedAfterDate();

    @Query(value = " SELECT DISTINCT p.* FROM PATIENT p" +
        " LEFT JOIN patient_medical_record as pmr ON p.patient_medical_record_id = pmr.patient_medical_record_id " +
        " LEFT JOIN patient_medial_record_symptom as mrs ON pmr.patient_medical_record_id = mrs.patient_medical_record_id" +
        " LEFT JOIN symptom as s ON mrs.symptom_id = s.symptom_id" +
        " AND s.description ='Coughing' OR s.description = 'Fever' ", nativeQuery = true)
    List<Patient> findAllPatientsWithSymptoms();

    Optional<Patient> findByEmail(String email);
}
