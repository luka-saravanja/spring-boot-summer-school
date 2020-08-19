package com.ag04smarts.sha.controller;


import java.util.Date;

import com.ag04smarts.sha.model.Appointment;
import com.ag04smarts.sha.service.AppointmentService;
import com.ag04smarts.sha.utils.MappingConstants;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = MappingConstants.APPOINTMENT)
public class AppointmentController {

    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping
    public HttpEntity<?> createAppointment(
        @RequestParam(name = "patientId") long patientId,
        @RequestParam(name = "doctorId") long doctorId,
        @RequestParam(name = "date") @DateTimeFormat(pattern = "dd.MM.yyyy") Date date
    ) {
        Appointment created = appointmentService.insert(patientId, doctorId, date);
        return ResponseEntity.ok(created);
    }
}
