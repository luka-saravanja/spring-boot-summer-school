package com.ag04smarts.sha.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.HashSet;
import java.util.Set;

import com.ag04smarts.sha.request.PatientResource;
import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@Table(name = "patients")
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
    private String phone;
    @Column(nullable = false)
    private String streetName;
    @Column(nullable = false)
    private String city;
    @Column(nullable = false)
    private String country;
    @OneToMany(mappedBy = "patient")
    private Set<Therapy> therapies;
    @ManyToMany
    @JoinTable(
        name = "patient_disease",
        joinColumns = @JoinColumn(name = "patientId"),
        inverseJoinColumns = @JoinColumn(name = "diseaseId"))
    Set<Disease> diseases;

    public Patient() {
    }

    public void addDisease(Disease disease) {
        if (diseases == null) {
            diseases = new HashSet<Disease>();
        }
        diseases.add(disease);
    }

    public void addTherapy(Therapy therapy) {
        if (therapies == null) {
            therapies = new HashSet<Therapy>();
        }
        therapies.add(therapy);
    }

    public void updateFromResource(PatientResource resource) {
        this.firstName = resource.getFirstName();
        this.lastName = resource.getLastName();
        this.email = resource.getEmail();
        this.phone = resource.getPhone();
        this.streetName = resource.getStreetName();
        this.city = resource.getCity();
        this.country = resource.getCountry();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return patientId != null && patientId.equals(patient.getPatientId());
    }

    @Override
    public int hashCode() {
        return patientId != null ? patientId.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Patient{" +
            "patientId=" + patientId +
            ", firstName='" + firstName + '\'' +
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

    public Set<Disease> getDiseases() {
        return diseases;
    }

    public void setDiseases(Set<Disease> diseases) {
        this.diseases = diseases;
    }
}
