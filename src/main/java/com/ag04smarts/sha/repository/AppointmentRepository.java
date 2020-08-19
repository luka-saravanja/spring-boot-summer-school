package com.ag04smarts.sha.repository;

import java.util.Date;
import java.util.Optional;

import com.ag04smarts.sha.model.Appointment;
import com.ag04smarts.sha.model.Doctor;
import com.ag04smarts.sha.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    Optional<Appointment> findByPatientAndDoctorAndEnlistmentDate(Patient patient, Doctor doctor, Date enlistmentDate);
}
