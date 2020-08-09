package com.ag04smarts.sha.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@Entity
@Table(name = "symptom")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Symptom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long symptomId;
    @Column(nullable = false)
    private String description;

    @ManyToMany(mappedBy = "symptoms")
    @JsonIgnore
    private Set<PatientMedicalRecord> patientMedicalRecords = new HashSet<>();
}
