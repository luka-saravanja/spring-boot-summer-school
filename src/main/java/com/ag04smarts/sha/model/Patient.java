package com.ag04smarts.sha.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import java.util.Date;
import java.util.Set;

import com.ag04smarts.sha.model.enums.Gender;
import com.ag04smarts.sha.model.enums.Status;
import com.ag04smarts.sha.request.PatientResource;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@Entity
@Table(name = "patient")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patientId;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false, unique = true)
    private String email;
    private Integer age;
    private String phoneNumber;
    private Date enlistmentDate;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patient")
    private Set<Appointment> appointments;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patient")
    private Set<PatientTreatmentHistory> patientTreatmentHistories;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "patient_medical_record_id", referencedColumnName = "patientMedicalRecordId")
    private PatientMedicalRecord patientMedicalRecord;


    public void updateFromResource(PatientResource resource) {
        this.firstName = resource.getFirstName();
        this.lastName = resource.getLastName();
        this.email = resource.getEmail();
        this.phoneNumber = resource.getPhone();
    }

}
