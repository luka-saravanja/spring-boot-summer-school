package com.ag04smarts.sha.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@Entity
@Table(name = "patient_medical_record")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class PatientMedicalRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patientMedicalRecordId;
    @Column(nullable = false)
    private String diagnosis;
    @Column(nullable = false)
    private String treatment;

    @OneToOne(mappedBy = "patientMedicalRecord")
    @JsonIgnore
    private Patient patient;


}
