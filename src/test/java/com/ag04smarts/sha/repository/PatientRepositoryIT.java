package com.ag04smarts.sha.repository;

import java.util.Optional;

import com.ag04smarts.sha.model.Patient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
class PatientRepositoryIT {

    @Autowired
    PatientRepository patientRepository;

    @Test
    void findByEmail() {
        Optional<Patient> patient = patientRepository.findByEmail("mario@email.com");

        assertEquals("mario@email.com", patient.get().getEmail());
    }
}