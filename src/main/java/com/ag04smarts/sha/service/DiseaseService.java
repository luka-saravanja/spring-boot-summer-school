package com.ag04smarts.sha.service;

import com.ag04smarts.sha.model.Disease;
import com.ag04smarts.sha.request.DiseaseResource;

public interface DiseaseService {

    /**
     * Returns {@link Disease} based on the given {@code id}
     *
     * @param id identifier of the wanted disease
     * @return an existing {@link Disease} based on the id
     */
    Disease findById(long id);

    /**
     * Creates a new {@link Disease} based on the given the data
     *
     * @param resource data to insert
     * @return an persisted {@link Disease}
     */
    Disease insert(DiseaseResource resource);

    /**
     * Updates an existing {@link Disease} based on the given the data
     *
     * @param resource data to update
     * @return an updated {@link Disease}
     */
    Disease update(DiseaseResource resource);

    /**
     * Deletes a {@link Disease} based on the given {@code id}
     *
     * @param id identifier of the disease that will be deleted
     */
    void delete(long id);
}
