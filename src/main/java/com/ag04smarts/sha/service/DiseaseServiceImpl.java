package com.ag04smarts.sha.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;

import com.ag04smarts.sha.model.Disease;
import com.ag04smarts.sha.repository.DiseaseRepository;
import com.ag04smarts.sha.request.DiseaseResource;
import org.springframework.beans.InvalidPropertyException;
import org.springframework.stereotype.Service;

@Service
public class DiseaseServiceImpl implements DiseaseService {

    private final DiseaseRepository diseaseRepository;
    @PersistenceContext
    private EntityManager entityManager;

    public DiseaseServiceImpl(DiseaseRepository diseaseRepository) {
        this.diseaseRepository = diseaseRepository;
    }

    @Override
    public Disease findById(long id) {
        return diseaseRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Disease insert(DiseaseResource resource) {
        if (diseaseRepository.findByName(resource.getName()).isPresent()) {
            throw new InvalidPropertyException(DiseaseResource.class, "name", "Disease with same name already exists");
        }
        Disease disease = resource.toDisease();
        return diseaseRepository.save(disease);
    }

    @Override
    public Disease update(DiseaseResource resource) {
        Disease persisted = findById(resource.getDiseaseId());
        if (diseaseRepository.findByName(resource.getName()).filter(d -> !d.getDiseaseId().equals(resource.getDiseaseId())).isPresent()) {
            throw new InvalidPropertyException(DiseaseResource.class, "name", "Disease with same name already exists");
        }
        persisted.setName(resource.getName());
        return diseaseRepository.save(persisted);
    }

    @Override
    public void delete(long id) {
        Disease persisted = findById(id);
        diseaseRepository.delete(persisted);
    }
}
