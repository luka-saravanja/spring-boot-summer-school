package com.ag04smarts.sha.model;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.Set;

import com.ag04smarts.sha.model.enums.DoctorExpertise;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@Table(name = "doctor")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Doctor extends BaseEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DoctorExpertise doctorExpertise;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "doctor")
    private Set<Appointment> appointments;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "doctor")
    private Set<PatientTreatmentHistory> patientTreatmentHistories;

    @Builder
    public Doctor(String firstName, String lastName, DoctorExpertise doctorExpertise) {
        super(firstName, lastName);
        this.doctorExpertise = doctorExpertise;
    }
}
