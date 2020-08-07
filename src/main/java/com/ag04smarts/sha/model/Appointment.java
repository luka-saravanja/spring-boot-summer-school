package com.ag04smarts.sha.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@Table(name = "appointment")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long appointmentId;
    @Column(nullable = false)
    private Date enlistmentDate;

    @ManyToOne
    @JoinColumn(name = "patient_id", referencedColumnName = "patientId", nullable = false)
    private Patient patient;
    @ManyToOne
    @JoinColumn(name = "doctor_id", referencedColumnName = "doctorId", nullable = false)
    private Doctor doctor;
}
