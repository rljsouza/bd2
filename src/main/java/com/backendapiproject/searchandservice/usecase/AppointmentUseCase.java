package com.backendapiproject.searchandservice.usecase;

import com.backendapiproject.searchandservice.core.domain.Appointment;

import java.util.List;

public interface AppointmentUseCase {
    Appointment cancel(Long id);

    Appointment confirm(Long id);

    Appointment create(Appointment appointment);

    Appointment getAppointmentById(Long id);

    List<Appointment> listCustomerAppointmentsByCustomerId(Long id);

    List<Appointment> listServiceAppointmentsUByServiceId(Long professionalId, Long id);
}

