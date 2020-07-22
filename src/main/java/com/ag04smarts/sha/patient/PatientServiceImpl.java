package com.ag04smarts.sha.patient;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;

import com.ag04smarts.sha.patient.model.Patient;
import com.ag04smarts.sha.patient.model.PatientResource;
import org.springframework.beans.InvalidPropertyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
@Qualifier("patientService")
public class PatientServiceImpl implements PatientService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private ApplicationContext applicationContext;
    private PatientRepository patientRepository;

    @PostConstruct
    private void init() {
        patientRepository = applicationContext.getBean(PatientRepository.class);
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
        if (patientRepository.findByEmail(resource.getEmail()).filter(p -> p.getPatientId().equals(resource.getPatientId())).isPresent()) {
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
}
