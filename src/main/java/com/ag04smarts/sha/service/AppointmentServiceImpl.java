package com.ag04smarts.sha.service;

import javax.persistence.EntityNotFoundException;
import java.util.Date;

import com.ag04smarts.sha.model.Appointment;
import com.ag04smarts.sha.model.Doctor;
import com.ag04smarts.sha.model.Patient;
import com.ag04smarts.sha.repository.AppointmentRepository;
import com.ag04smarts.sha.repository.DoctorRepository;
import com.ag04smarts.sha.repository.PatientRepository;
import com.ag04smarts.sha.request.AppointmentForm;
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
    public Appointment insert(AppointmentForm form) {
        Patient patient = patientRepository.findById(form.getPatientId())
            .orElseThrow(EntityNotFoundException::new);
        Doctor doctor = doctorRepository.findById(form.getDoctorId())
            .orElseThrow(EntityNotFoundException::new);

        if (appointmentRepository.findByPatientAndDoctorAndEnlistmentDate(patient, doctor, form.getDate()).isPresent()) {
            throw new IllegalArgumentException("This doctor and patient have appointment on selected date");
        }

        Appointment appointment = new Appointment();
        appointment.setEnlistmentDate(form.getDate());
        appointment.setPatient(patient);
        appointment.setDoctor(doctor);

        return appointmentRepository.save(appointment);
    }
}
