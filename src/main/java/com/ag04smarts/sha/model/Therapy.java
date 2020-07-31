package com.ag04smarts.sha.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@Table(name = "therapies")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Therapy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long therapyId;
    @Column(nullable = false)
    private LocalDate startDate;
    @Column(nullable = false)
    private LocalDate endDate;
    @Column(nullable = false)
    private String medicine;
    @ManyToOne
    @JoinColumn(name = "patientId", nullable = false)
    private Patient patient;

    public Therapy() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Therapy therapy = (Therapy) o;
        return therapyId != null && therapyId.equals(therapy.getTherapyId());
    }

    @Override
    public int hashCode() {
        return therapyId != null ? therapyId.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Therapy{" +
            "therapyId=" + therapyId +
            ", startDate=" + startDate +
            ", endDate=" + endDate +
            ", medicine='" + medicine + '\'' +
            ", patient=" + patient +
            '}';
    }

    public Long getTherapyId() {
        return therapyId;
    }

    public void setTherapyId(Long therapyId) {
        this.therapyId = therapyId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getMedicine() {
        return medicine;
    }

    public void setMedicine(String medicine) {
        this.medicine = medicine;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
