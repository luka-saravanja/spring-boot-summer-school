package com.ag04smarts.sha.controller;


import javax.validation.Valid;


import com.ag04smarts.sha.model.Appointment;
import com.ag04smarts.sha.request.AppointmentForm;
import com.ag04smarts.sha.service.AppointmentService;
import com.ag04smarts.sha.utils.MappingConstants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Api(description = "This is controller used for creating a new appointment")
@RestController
@RequestMapping(value = MappingConstants.APPOINTMENT)
public class AppointmentController {

    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @ApiOperation(value = "Create an appointment", response = Appointment.class)
    @PostMapping
    public HttpEntity<?> createAppointment(
        @ApiParam(value = "Object which contains information used to insert a new appointment", required = true)
        @RequestBody @Valid AppointmentForm form
    ) {
        Appointment created = appointmentService.insert(form);
        return ResponseEntity.ok(created);
    }
}
