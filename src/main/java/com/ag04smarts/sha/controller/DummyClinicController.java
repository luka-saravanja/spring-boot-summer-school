package com.ag04smarts.sha.controller;

import com.ag04smarts.sha.config.DummyClinicWebData;
import com.ag04smarts.sha.config.DummyClinicService;
import com.ag04smarts.sha.utils.MappingConstants;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = MappingConstants.CLINIC_DATA)
public class DummyClinicController {

    private final DummyClinicService dummyClinicWebDataService;

    public DummyClinicController(DummyClinicService dummyClinicWebDataService) {
        this.dummyClinicWebDataService = dummyClinicWebDataService;
    }

    @GetMapping(value = "/web-data")
    public ResponseEntity<?> getClinicWebData(
    ) {
        DummyClinicWebData clinicWebData = dummyClinicWebDataService.getClinicWebData();
        return ResponseEntity.ok(clinicWebData);
    }

    @GetMapping("/name")
    public ResponseEntity<?> getClinicName(
    ) {
        return ResponseEntity.ok(dummyClinicWebDataService.getClinicName());
    }
}
