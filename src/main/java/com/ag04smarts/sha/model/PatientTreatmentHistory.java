package com.ag04smarts.sha.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ag04smarts.sha.model.enums.Status;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@Entity
@Table(name = "patient_treatment_history")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class PatientTreatmentHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patientTreatmentHistoryId;
    @Column(nullable = false)
    private String treatmentRemark;
    @Enumerated(EnumType.STRING)
    private Status oldStatus;
    @Enumerated(EnumType.STRING)
    private Status newStatus;

    @ManyToOne
    @JoinColumn(name = "patient_id", referencedColumnName = "patientId", nullable = false)
    private Patient patient;
    @ManyToOne
    @JoinColumn(name = "doctor_id", referencedColumnName = "doctorId", nullable = false)
    private Doctor doctor;
}
