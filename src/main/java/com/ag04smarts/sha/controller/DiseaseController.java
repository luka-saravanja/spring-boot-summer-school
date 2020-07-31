package com.ag04smarts.sha.controller;


import javax.validation.Valid;

import com.ag04smarts.sha.model.Disease;
import com.ag04smarts.sha.request.DiseaseResource;
import com.ag04smarts.sha.service.DiseaseService;
import com.ag04smarts.sha.utils.MappingConstants;
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

@RestController
@RequestMapping(value = MappingConstants.DISEASE)
public class DiseaseController {

    private final DiseaseService diseaseService;

    public DiseaseController(DiseaseService diseaseService) {
        this.diseaseService = diseaseService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> diseaseById(
        @PathVariable("id") long id
    ) {
        Disease disease = diseaseService.findById(id);
        return ResponseEntity.ok(disease);
    }

    @PostMapping
    public HttpEntity<?> createDisease(
        @RequestBody @Valid DiseaseResource resource
    ) {
        Disease created = diseaseService.insert(resource);
        return ResponseEntity.ok(created);
    }

    @PutMapping("/{id}")
    public HttpEntity<?> updateDisease(
        @PathVariable("id") long id,
        @RequestBody @Valid DiseaseResource resource
    ) {
        resource.setDiseaseId(id);
        Disease updated = diseaseService.update(resource);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDiseaseById(
        @PathVariable("id") long id
    ) {
        diseaseService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
