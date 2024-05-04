package com.backendapiproject.searchandservice.usecase;

import com.backendapiproject.searchandservice.core.domain.Appointment;

public interface AppointmentUseCase {
    Appointment cancel(Long id);

    Appointment confirm(Long id);

    Appointment create(Appointment appointment);

    Appointment getAppointmentById(Long id);
}

