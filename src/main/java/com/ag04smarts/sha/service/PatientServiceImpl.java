package com.ag04smarts.sha.service;

import javax.persistence.EntityNotFoundException;

import java.io.IOException;
import java.util.List;

import com.ag04smarts.sha.model.Patient;
import com.ag04smarts.sha.repository.PatientRepository;
import com.ag04smarts.sha.request.EnlistmentForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

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
    public Patient insert(Patient patient) {
        log.info("Building new patient");

        if (patientRepository.findByEmail(patient.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Patient with same email already exists");
        }

        return patientRepository.save(patient);
    }

    @Override
    public Patient update(EnlistmentForm resource) {
        Patient persisted = findById(resource.getPatientId());
        if (patientRepository.findByEmail(resource.getEmail()).filter(p -> !p.getId().equals(resource.getPatientId())).isPresent()) {
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

    @Override
    @Transactional
    public void addPatientPicture(long patientId, MultipartFile image) {
        Patient patient = findById(patientId);
        try {
            Byte[] bytes = new Byte[image.getBytes().length];

            int i = 0;

            for (byte b : image.getBytes()) {
                bytes[i++] = b;
            }

            patient.setPicture(bytes);

            patientRepository.save(patient);
        } catch (IOException e) {
            log.info("error in picture upload");
            e.printStackTrace();
        }
    }

}
