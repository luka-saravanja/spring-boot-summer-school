package com.ag04smarts.sha.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@Table(name = "diseases")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Disease {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long diseaseId;
    @Column(nullable = false, unique = true)
    private String name;
    @ManyToMany(mappedBy = "diseases")
    @JsonIgnore
    Set<Patient> patients;

    public Disease() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Disease disease = (Disease) o;
        return Objects.equals(diseaseId, disease.diseaseId) &&
            name.equals(disease.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(diseaseId, name);
    }

    @Override
    public String toString() {
        return "Disease{" +
            "diseaseId=" + diseaseId +
            ", name='" + name + '\'' +
            '}';
    }

    public Long getDiseaseId() {
        return diseaseId;
    }

    public void setDiseaseId(Long diseaseId) {
        this.diseaseId = diseaseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Patient> getPatients() {
        return patients;
    }

    public void setPatients(Set<Patient> patients) {
        this.patients = patients;
    }
}
