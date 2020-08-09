package com.ag04smarts.sha.controller;

import javax.xml.crypto.Data;

import java.util.Date;

import com.ag04smarts.sha.model.Patient;
import com.ag04smarts.sha.model.enums.Gender;
import com.ag04smarts.sha.model.enums.Status;
import com.ag04smarts.sha.request.PatientResource;
import com.ag04smarts.sha.service.PatientService;
import com.ag04smarts.sha.service.PatientServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(value = PatientController.class)
class PatientControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private PatientService patientService;

    @Test
    void patientById() throws Exception {
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

        when(patientService.findById(1)).thenReturn(patient);

        this.mockMvc.perform(get("/api/patient/1")
            .contentType(MediaType.APPLICATION_JSON))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(jsonPath("$").exists())
            .andExpect(jsonPath("$.firstName").value(patient.getFirstName()))
            .andExpect(jsonPath("$.lastName").value(patient.getLastName()))
            .andExpect(jsonPath("$.id").value(patient.getId()))
            .andExpect(jsonPath("$.email").value(patient.getEmail()))
            .andExpect(jsonPath("$.age").value(patient.getAge()))
            .andExpect(jsonPath("$.gender").value(String.valueOf(patient.getGender())))
            .andExpect(jsonPath("$.status").value(String.valueOf(patient.getStatus())));

        verify(patientService).findById(1);
    }
}