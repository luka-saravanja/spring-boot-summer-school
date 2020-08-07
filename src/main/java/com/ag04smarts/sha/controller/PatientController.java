package com.ag04smarts.sha.controller;

import javax.validation.Valid;


import java.util.List;

import com.ag04smarts.sha.model.Patient;
import com.ag04smarts.sha.service.PatientService;
import com.ag04smarts.sha.request.PatientResource;


import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ag04smarts.sha.utils.MappingConstants;

@RestController
@RequestMapping(value = MappingConstants.PATIENT)
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> patientById(
        @PathVariable("id") long id
    ) {
        Patient patient = patientService.findById(id);
        return ResponseEntity.ok(patient);
    }

    @PostMapping
    public HttpEntity<?> createPatient(
        @RequestBody @Valid PatientResource resource
    ) {
        Patient created = patientService.insert(resource);
        return ResponseEntity.ok(created);
    }

    @PutMapping("/{id}")
    public HttpEntity<?> updatePatient(
        @PathVariable("id") long id,
        @RequestBody @Valid PatientResource resource
    ) {
        resource.setPatientId(id);
        Patient updated = patientService.update(resource);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePatientById(
        @PathVariable("id") long id
    ) {
        patientService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/older")
    public ResponseEntity<?> patientsOlderThan21AndEnlistedAfterDate(
    ) {
        List<Patient> patients = patientService.getAllPatientsOlderThan21AndEnlistedAfterDate();
        return ResponseEntity.ok(patients);
    }

    @GetMapping("/symptoms")
    public ResponseEntity<?> patientsWithFeverOrCoughing(
    ) {
        List<Patient> patients = patientService.getAllPatientsWithFeverOrCoughingSymptoms();
        return ResponseEntity.ok(patients);
    }

}
