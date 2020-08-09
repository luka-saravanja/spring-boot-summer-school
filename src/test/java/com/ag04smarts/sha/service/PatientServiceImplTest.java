package com.ag04smarts.sha.service;

import java.util.Optional;

import com.ag04smarts.sha.model.Patient;
import com.ag04smarts.sha.model.enums.Gender;
import com.ag04smarts.sha.model.enums.Status;
import com.ag04smarts.sha.repository.PatientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class PatientServiceImplTest {

    PatientServiceImpl patientService;

    @Mock
    PatientRepository patientRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        patientService = new PatientServiceImpl(patientRepository);
    }

    @Test
    void findById() {
        Patient patient = Patient.builder()
            .firstName("Ime")
            .lastName("Prezime")
            .email("email@email.com")
            .phoneNumber("12948051")
            .age(22)
            .status(Status.ENLISTED)
            .gender(Gender.MALE)
            .build();
        patient.setId((long) 1);

        Mockito.when(patientRepository.findById((long)1)).thenReturn(Optional.of(patient));

        Patient servicePatient = patientService.findById(1);

        assertEquals(servicePatient, patient);

        Mockito.verify(patientRepository, Mockito.times(1));

    }
}