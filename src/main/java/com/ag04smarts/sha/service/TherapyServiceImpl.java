package com.ag04smarts.sha.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;

import com.ag04smarts.sha.model.Patient;
import com.ag04smarts.sha.model.Therapy;
import com.ag04smarts.sha.repository.PatientRepository;
import com.ag04smarts.sha.repository.TherapyRepository;
import com.ag04smarts.sha.request.TherapyResource;

public class TherapyServiceImpl implements TherapyService {

    private final TherapyRepository therapyRepository;
    private final PatientRepository patientRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public TherapyServiceImpl(TherapyRepository therapyRepository, PatientRepository patientRepository) {
        this.therapyRepository = therapyRepository;
        this.patientRepository = patientRepository;
    }

    @Override
    public Therapy findById(long id) {
        return therapyRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Therapy insert(TherapyResource resource) {
        Patient patient = patientRepository.findById(resource.getPatientId()).orElseThrow(EntityNotFoundException::new);
        Therapy therapy = resource.toTherapy();
        therapy.setPatient(patient);
        patient.addTherapy(therapy);
        return therapyRepository.save(therapy);
    }

    @Override
    public void delete(long id) {
        Therapy toDelete = findById(id);
        therapyRepository.delete(toDelete);

    }
}
