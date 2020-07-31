package com.ag04smarts.sha.repository;

import java.util.List;

import com.ag04smarts.sha.model.Patient;
import com.ag04smarts.sha.model.Therapy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TherapyRepository extends JpaRepository<Therapy, Long> {
    List<Therapy> findByPatient(Patient patient);
}
