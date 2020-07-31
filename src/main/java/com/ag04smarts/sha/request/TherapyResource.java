package com.ag04smarts.sha.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.time.LocalDate;

import com.ag04smarts.sha.model.Therapy;

public class TherapyResource {

    @NotNull
    private Long patientId;
    @NotNull
    private LocalDate startDate;
    @NotNull
    private LocalDate endDate;
    @NotBlank
    private String medicine;

    public TherapyResource() {
    }

    public Therapy toTherapy() {
        Therapy therapy = new Therapy();
        therapy.setStartDate(this.startDate);
        therapy.setEndDate(this.endDate);
        therapy.setMedicine(this.medicine);
        return therapy;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
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

}
