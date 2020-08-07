package com.ag04smarts.sha.repository;

import com.ag04smarts.sha.model.MedicalRecordSymptom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalRecordSymptomRepository extends JpaRepository<MedicalRecordSymptom, Long> {
}
