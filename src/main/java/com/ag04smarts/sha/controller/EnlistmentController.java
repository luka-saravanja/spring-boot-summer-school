package com.ag04smarts.sha.controller;

import javax.validation.Valid;

import com.ag04smarts.sha.converter.EnlistmentFormToPatientConverter;
import com.ag04smarts.sha.model.Patient;
import com.ag04smarts.sha.request.EnlistmentForm;
import com.ag04smarts.sha.service.PatientService;
import com.ag04smarts.sha.utils.MappingConstants;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = MappingConstants.ENLISTMENT)
public class EnlistmentController {

    private final PatientService patientService;
    private final EnlistmentFormToPatientConverter converter;

    public EnlistmentController(PatientService patientService, EnlistmentFormToPatientConverter converter) {
        this.patientService = patientService;
        this.converter = converter;
    }

    @PostMapping
    public HttpEntity<?> createPatient(
        @Valid @RequestBody EnlistmentForm form
    ) {
        Patient created = patientService.insert(converter.convert(form));
        return ResponseEntity.ok(created);
    }
}
