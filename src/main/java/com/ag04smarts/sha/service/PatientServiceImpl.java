package com.ag04smarts.sha.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;

import java.util.List;

import com.ag04smarts.sha.model.Disease;
import com.ag04smarts.sha.model.Patient;
import com.ag04smarts.sha.model.Therapy;
import com.ag04smarts.sha.repository.DiseaseRepository;
import com.ag04smarts.sha.repository.PatientRepository;
import com.ag04smarts.sha.repository.TherapyRepository;
import com.ag04smarts.sha.request.PatientResource;
import org.springframework.beans.InvalidPropertyException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
@Qualifier("patientService")
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;
    private final DiseaseRepository diseaseRepository;
    private final TherapyRepository therapyRepository;

    public PatientServiceImpl(PatientRepository patientRepository, DiseaseRepository diseaseRepository, TherapyRepository therapyRepository) {
        this.patientRepository = patientRepository;
        this.diseaseRepository = diseaseRepository;
        this.therapyRepository = therapyRepository;
    }

    @Override
    public Patient findById(long id) {
        return patientRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Patient insert(PatientResource resource) {
        if (patientRepository.findByEmail(resource.getEmail()).isPresent()) {
            throw new InvalidPropertyException(PatientResource.class, "email", "Email already in use");
        }
        Patient patient = resource.toPatientEntity();
        return patientRepository.save(patient);
    }

    @Override
    public Patient update(PatientResource resource) {
        if (patientRepository.findByEmail(resource.getEmail()).filter(p -> !p.getPatientId().equals(resource.getPatientId())).isPresent()) {
            throw new InvalidPropertyException(PatientResource.class, "email", "Email already in use");
        }
        Patient persisted = findById(resource.getPatientId());
        persisted.updateFromResource(resource);
        return patientRepository.save(persisted);
    }

    @Override
    public void delete(long id) {
        Patient toDelete = findById(id);
        patientRepository.delete(toDelete);
    }

    @Override
    public Patient addDisease(String diseaseName, Long patientId) {
        Patient patient = findById(patientId);
        Disease disease = diseaseRepository.findByName(diseaseName).orElseThrow(EntityNotFoundException::new);
        patient.addDisease(disease);
        return patientRepository.save(patient);
    }

    @Override
    public List<Therapy> findPatientTherapies(long patientId) {
        Patient patient = findById(patientId);
        return therapyRepository.findByPatient(patient);
    }
}
