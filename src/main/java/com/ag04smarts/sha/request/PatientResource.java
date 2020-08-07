package com.ag04smarts.sha.request;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.ag04smarts.sha.model.enums.Gender;
import com.ag04smarts.sha.model.Patient;
import com.ag04smarts.sha.model.enums.Status;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class PatientResource {

    @JsonIgnore
    private Long patientId;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    @Email
    private String email;
    private String phone;
    @NotNull
    private Gender gender;
    @NotNull
    private Status status;


    public PatientResource() {
    }

    public Patient toPatientEntity() {
        Patient patient = new Patient();
//        patient.setFirstName(this.firstName);
//        patient.setLastName(this.lastName);
//        patient.setEmail(this.email);
//        patient.setPhoneNumber(this.phone);
//        patient.setStatus(this.status);
//        patient.setGender(this.gender);
        return patient;
    }

    public PatientResource(@NotBlank String firstName, @NotBlank String lastName, @NotBlank @Email String email, String phone, @NotBlank String streetName, @NotBlank String city, @NotBlank String country) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


}
