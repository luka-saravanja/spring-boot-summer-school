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
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

import com.ag04smarts.sha.model.enums.Gender;
import com.ag04smarts.sha.model.enums.Status;
import com.ag04smarts.sha.request.PatientResource;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;


@Builder(toBuilder = true)
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
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

    private LocalDateTime createdAt;
    private LocalDateTime lastUpdated;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patient")
    private Set<Appointment> appointments;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patient")
    @JsonIgnore
    private Set<PatientTreatmentHistory> patientTreatmentHistories;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "patient_medical_record_id", referencedColumnName = "patientMedicalRecordId")
    private PatientMedicalRecord patientMedicalRecord;


    @PrePersist
    private void createdAt() {
        this.createdAt = LocalDateTime.now();
    }

    @PreUpdate
    private void lastUpdated() {
        this.lastUpdated = LocalDateTime.now();
    }

    public void updateFromResource(PatientResource resource) {
        this.firstName = resource.getFirstName();
        this.lastName = resource.getLastName();
        this.email = resource.getEmail();
        this.age = resource.getAge();
        this.phoneNumber = resource.getPhone();
        this.status = resource.getStatus();
        this.gender = resource.getGender();
    }

}
