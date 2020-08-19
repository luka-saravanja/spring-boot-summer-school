package com.ag04smarts.sha.service;

import javax.persistence.EntityNotFoundException;
import java.util.Date;

import com.ag04smarts.sha.model.Appointment;
import com.ag04smarts.sha.model.Doctor;
import com.ag04smarts.sha.model.Patient;
import com.ag04smarts.sha.repository.AppointmentRepository;
import com.ag04smarts.sha.repository.DoctorRepository;
import com.ag04smarts.sha.repository.PatientRepository;
import org.springframework.stereotype.Service;

@Service
public class AppointmentServiceImpl implements AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository, DoctorRepository doctorRepository, PatientRepository patientRepository) {
        this.appointmentRepository = appointmentRepository;
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
    }

    @Override
    public Appointment insert(long patientId, long doctorId, Date date) {
        Patient patient = patientRepository.findById(patientId)
            .orElseThrow(EntityNotFoundException::new);
        Doctor doctor = doctorRepository.findById(doctorId)
            .orElseThrow(EntityNotFoundException::new);

        if (appointmentRepository.findByPatientAndDoctorAndEnlistmentDate(patient, doctor, date).isPresent()) {
            throw new IllegalArgumentException("This doctor and patient have appointment on selected date");
        }

        Appointment appointment = new Appointment();
        appointment.setEnlistmentDate(date);
        appointment.setPatient(patient);
        appointment.setDoctor(doctor);

        return appointmentRepository.save(appointment);
    }
}
