package com.ag04smarts.sha.controller;

import javax.validation.Valid;


import java.util.List;

import com.ag04smarts.sha.model.Patient;
import com.ag04smarts.sha.service.PatientService;
import com.ag04smarts.sha.request.EnlistmentForm;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import com.ag04smarts.sha.utils.MappingConstants;
import org.springframework.web.multipart.MultipartFile;

@Api(description = "This is controller for CRUD operations on patient except creating a new patient")
@RestController
@RequestMapping(value = MappingConstants.PATIENT)
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @ApiOperation(value = "Get patient by identifier", response = Patient.class)
    @GetMapping("/{id}")
    public ResponseEntity<?> patientById(
        @ApiParam(value = "Identifier of patient", required = true) @PathVariable("id") long id
    ) {
        Patient patient = patientService.findById(id);
        return ResponseEntity.ok(patient);
    }

    @ApiOperation(value = "Update patient data", response = Patient.class)
    @PutMapping("/{id}")
    public HttpEntity<?> updatePatient(
        @ApiParam(value = "Identifier of patient", required = true) @PathVariable("id") long id,
        @ApiParam(value = "Data which will be updated", required = true) @RequestBody @Valid EnlistmentForm resource
    ) {
        resource.setPatientId(id);
        Patient updated = patientService.update(resource);
        return ResponseEntity.ok(updated);
    }

    @ApiOperation(value = "Delete an patient")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePatientById(
        @ApiParam(value = "Identifier of patient", required = true) @PathVariable("id") long id
    ) {
        patientService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @ApiOperation(value = "Get all patients older than 21 and enlisted after 1.1.2020", response = Patient.class, responseContainer = "List")
    @GetMapping("/older")
    public ResponseEntity<?> patientsOlderThan21AndEnlistedAfterDate(
    ) {
        List<Patient> patients = patientService.getAllPatientsOlderThan21AndEnlistedAfterDate();
        return ResponseEntity.ok(patients);
    }

    @ApiOperation(value = "Get all patients with fever or coughing as symptoms", response = Patient.class, responseContainer = "List")
    @GetMapping("/symptoms")
    public ResponseEntity<?> patientsWithFeverOrCoughing(
    ) {
        List<Patient> patients = patientService.getAllPatientsWithFeverOrCoughingSymptoms();
        return ResponseEntity.ok(patients);
    }

    @ApiOperation(value = "Add picture to patient")
    @PutMapping("/{patientId}/add-picture")
    public void addPatientPicture(
        @ApiParam(value = "Identifier of patient", required = true) @PathVariable("patientId") long patientId,
        @ApiParam(value = "Picture to insert", required = true) @RequestPart("picture") MultipartFile file
    ) {
        patientService.addPatientPicture(patientId, file);
    }

}
