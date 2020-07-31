package com.ag04smarts.sha.request;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.ag04smarts.sha.model.Patient;
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
    @NotBlank
    private String streetName;
    @NotBlank
    private String city;
    @NotBlank
    private String country;

    public PatientResource() {
    }

    public Patient toPatientEntity() {
        Patient patient = new Patient();
        patient.setFirstName(this.firstName);
        patient.setLastName(this.lastName);
        patient.setEmail(this.email);
        patient.setPhone(this.phone);
        patient.setStreetName(this.streetName);
        patient.setCity(this.city);
        patient.setCountry(this.country);
        return patient;
    }

    public PatientResource(@NotBlank String firstName, @NotBlank String lastName, @NotBlank @Email String email, String phone, @NotBlank String streetName, @NotBlank String city, @NotBlank String country) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.streetName = streetName;
        this.city = city;
        this.country = country;
    }

    @Override
    public String toString() {
        return "PatientResource{" +
            "firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", email='" + email + '\'' +
            ", phone='" + phone + '\'' +
            ", streetName='" + streetName + '\'' +
            ", city='" + city + '\'' +
            ", country='" + country + '\'' +
            '}';
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

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
