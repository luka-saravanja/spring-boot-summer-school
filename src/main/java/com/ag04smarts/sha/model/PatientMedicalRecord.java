package com.ag04smarts.sha.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import java.util.HashSet;
import java.util.Set;

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

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
        name = "patient_medial_record_symptom",
        joinColumns = {@JoinColumn(name = "patient_medical_record_id")},
        inverseJoinColumns = {@JoinColumn(name = "symptom_id")}
    )
    @JsonIgnore
    Set<Symptom> symptoms = new HashSet<>();


}
