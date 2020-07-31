package com.ag04smarts.sha.service;

import java.util.List;

import com.ag04smarts.sha.model.Patient;
import com.ag04smarts.sha.model.Therapy;
import com.ag04smarts.sha.request.PatientResource;

public interface PatientService {

    /**
     * Returns {@link Patient} based on the given {@code id}
     *
     * @param id identifier of the wanted patient
     * @return an existing {@link Patient} based on the id
     */
    Patient findById(long id);

    /**
     * Creates a new {@link Patient} based on the given the data
     *
     * @param resource data to insert
     * @return an persisted {@link Patient}
     */
    Patient insert(PatientResource resource);

    /**
     * Updates an existing {@link Patient} based on the given the data
     *
     * @param resource data to update
     * @return an updated {@link Patient}
     */
    Patient update(PatientResource resource);

    /**
     * Deletes a {@link Patient} based on the given {@code id}
     *
     * @param id identifier of the patient that will be deleted
     */
    void delete(long id);

    /**
     * Method for adding new disease to patient
     *
     * @param diseaseName name of disease to add to Patient
     * @param patientId   identifier of Patient
     * @return Patient with new Disease
     */
    Patient addDisease(String diseaseName, Long patientId);

    List<Therapy> findPatientTherapies(long patientId);
}
