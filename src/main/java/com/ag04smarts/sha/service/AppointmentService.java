package com.ag04smarts.sha.service;

import java.util.Date;

import com.ag04smarts.sha.model.Appointment;
import com.ag04smarts.sha.request.AppointmentForm;;

public interface AppointmentService {

    /**
     * Creates a new {@link Appointment} based on the given the data
     *
     * @param form data to insert
     * @return an persisted {@link Appointment}
     */
    Appointment insert(AppointmentForm form);
}
