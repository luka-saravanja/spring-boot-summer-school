package com.ag04smarts.sha.request;

import javax.validation.constraints.NotBlank;

import com.ag04smarts.sha.model.Disease;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class DiseaseResource {

    @JsonIgnore
    private long diseaseId;
    @NotBlank
    private String name;

    public DiseaseResource() {
    }

    public Disease toDisease() {
        Disease disease = new Disease();
        disease.setName(this.name);
        return disease;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getDiseaseId() {
        return diseaseId;
    }

    public void setDiseaseId(long diseaseId) {
        this.diseaseId = diseaseId;
    }
}
