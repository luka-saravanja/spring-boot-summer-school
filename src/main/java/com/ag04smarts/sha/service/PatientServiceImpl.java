package com.ag04smarts.sha.service;

import javax.persistence.EntityNotFoundException;

import java.util.List;

import com.ag04smarts.sha.model.Patient;
import com.ag04smarts.sha.repository.PatientRepository;
import com.ag04smarts.sha.request.PatientResource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
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
        log.info("Building new patient");

        if (patientRepository.findByEmail(resource.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Patient with same email already exists");
        }

        Patient patient = Patient.builder()
            .firstName(resource.getFirstName())
            .lastName(resource.getLastName())
            .email(resource.getEmail())
            .phoneNumber(resource.getPhone())
            .age(resource.getAge())
            .status(resource.getStatus())
            .gender(resource.getGender())
            .build();

        return patientRepository.save(patient);
    }

    @Override
    public Patient update(PatientResource resource) {
        Patient persisted = findById(resource.getPatientId());
        if (patientRepository.findByEmail(resource.getEmail()).filter(p -> !p.getPatientId().equals(resource.getPatientId())).isPresent()) {
            throw new IllegalArgumentException("Patient with same email already exists");
        }
        persisted.updateFromResource(resource);
        return patientRepository.save(persisted);
    }

    @Override
    public void delete(long id) {
        Patient toDelete = findById(id);
        patientRepository.delete(toDelete);
    }

    @Override
    public List<Patient> getAllPatientsOlderThan21AndEnlistedAfterDate() {
        log.info("Getting all patients older than 21 and enlisted after 01.01.2020");
        return patientRepository.findAllPatientsOlderThan21AndEnlistedAfterDate();
    }

    @Override
    public List<Patient> getAllPatientsWithFeverOrCoughingSymptoms() {
        log.info("Getting all patients with Fever or Coughing");
        return patientRepository.findAllPatientsWithSymptoms();
    }

}
