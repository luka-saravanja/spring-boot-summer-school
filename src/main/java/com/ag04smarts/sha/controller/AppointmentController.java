package com.ag04smarts.sha.controller;


import javax.validation.Valid;


import com.ag04smarts.sha.model.Appointment;
import com.ag04smarts.sha.request.AppointmentForm;
import com.ag04smarts.sha.service.AppointmentService;
import com.ag04smarts.sha.utils.MappingConstants;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
        @Valid @RequestBody AppointmentForm form
    ) {
        Appointment created = appointmentService.insert(form);
        return ResponseEntity.ok(created);
    }
}
