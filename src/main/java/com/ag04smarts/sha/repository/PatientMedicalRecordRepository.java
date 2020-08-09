package com.ag04smarts.sha.repository;

import com.ag04smarts.sha.model.PatientMedicalRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientMedicalRecordRepository extends JpaRepository<PatientMedicalRecord, Long> {
}
