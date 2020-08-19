package com.ag04smarts.sha.service;


import java.util.List;

import com.ag04smarts.sha.model.Patient;
import com.ag04smarts.sha.request.EnlistmentForm;

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
     * @param patient data to insert
     * @return an persisted {@link Patient}
     */
    Patient insert(Patient patient);

    /**
     * Updates an existing {@link Patient} based on the given the data
     *
     * @param resource data to update
     * @return an updated {@link Patient}
     */
    Patient update(EnlistmentForm resource);

    /**
     * Deletes a {@link Patient} based on the given {@code id}
     *
     * @param id identifier of the patient that will be deleted
     */
    void delete(long id);

    List<Patient> getAllPatientsOlderThan21AndEnlistedAfterDate();

    List<Patient> getAllPatientsWithFeverOrCoughingSymptoms();
}
