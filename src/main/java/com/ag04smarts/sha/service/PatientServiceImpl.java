package com.ag04smarts.sha.service;

import javax.persistence.EntityNotFoundException;

import java.util.List;

import com.ag04smarts.sha.model.Patient;
import com.ag04smarts.sha.repository.PatientRepository;
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


    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public Patient findById(long id) {
        return patientRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Patient insert(PatientResource resource) {
        Patient patient = resource.toPatientEntity();
        return patientRepository.save(patient);
    }

    @Override
    public Patient update(PatientResource resource) {
        Patient persisted = findById(resource.getPatientId());
        return patientRepository.save(persisted);
    }

    @Override
    public void delete(long id) {
        Patient toDelete = findById(id);
        patientRepository.delete(toDelete);
    }

}
