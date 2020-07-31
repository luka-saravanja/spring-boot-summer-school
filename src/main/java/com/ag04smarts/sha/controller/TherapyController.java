package com.ag04smarts.sha.controller;

import javax.validation.Valid;

import com.ag04smarts.sha.model.Therapy;
import com.ag04smarts.sha.request.TherapyResource;
import com.ag04smarts.sha.service.TherapyService;
import com.ag04smarts.sha.utils.MappingConstants;
import org.springframework.context.annotation.ImportResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = MappingConstants.THERAPY)
@ImportResource({"classpath*:therapy.xml"})
public class TherapyController {

    private final TherapyService therapyService;

    public TherapyController(TherapyService therapyService) {
        this.therapyService = therapyService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> therapyById(@PathVariable("id") long id) {
        Therapy therapy = therapyService.findById(id);
        return ResponseEntity.ok(therapy);
    }

    @PostMapping
    public HttpEntity<?> createTherapy(@RequestBody @Valid TherapyResource resource) {
        Therapy created = therapyService.insert(resource);
        return ResponseEntity.ok(created);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTherapyById(
        @PathVariable("id") long id
    ) {
        therapyService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
