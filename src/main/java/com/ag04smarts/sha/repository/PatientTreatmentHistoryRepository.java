package com.ag04smarts.sha.repository;

import com.ag04smarts.sha.model.PatientTreatmentHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientTreatmentHistoryRepository extends JpaRepository<PatientTreatmentHistory, Long> {
}
