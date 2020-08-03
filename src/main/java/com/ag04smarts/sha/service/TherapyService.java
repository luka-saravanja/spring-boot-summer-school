package com.ag04smarts.sha.service;

import com.ag04smarts.sha.model.Therapy;
import com.ag04smarts.sha.request.TherapyResource;

public interface TherapyService {

    /**
     * Returns {@link Therapy} based on the given {@code id}
     *
     * @param id identifier of the wanted disease
     * @return an existing {@link Therapy} based on the id
     */
    Therapy findById(long id);

    /**
     * Creates a new {@link Therapy} based on the given the data
     *
     * @param resource data to insert
     * @return an persisted {@link Therapy}
     */
    Therapy insert(TherapyResource resource);

    /**
     * Deletes a {@link Therapy} based on the given {@code id}
     *
     * @param id identifier of the therapy that will be deleted
     */
    void delete(long id);
}
