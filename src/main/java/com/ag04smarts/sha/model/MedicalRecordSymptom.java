package com.ag04smarts.sha.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import lombok.Data;


@Data
@Entity
@Table(name = "medical_record_symptoms")
public class MedicalRecordSymptom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @MapsId("patientMedicalRecordId")
    @JoinColumn(name = "patient_medical_record_id", referencedColumnName = "patientMedicalRecordId")
    private PatientMedicalRecord record;
    @ManyToOne
    @MapsId("symptomId")
    @JoinColumn(name = "symptom_id", referencedColumnName = "symptomId")
    private Symptom symptom;

}
