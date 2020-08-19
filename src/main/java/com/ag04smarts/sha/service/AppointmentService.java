package com.ag04smarts.sha.service;

import java.util.Date;

import com.ag04smarts.sha.model.Appointment;;

public interface AppointmentService {

    /**
     * Creates a new {@link Appointment} based on the given the data
     *
     * @param patientId identifier of pacient
     * @param doctorId  identifier of doctor
     * @param date      date of appointment
     * @return an persisted {@link Appointment}
     */
    Appointment insert(long patientId, long doctorId, Date date);
}
