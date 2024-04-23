package com.backendapiproject.searchandservice.usecase;

import com.backendapiproject.searchandservice.core.domain.Appointment;

interface ListCusppointmentsUseCase {
    List<Appointment> listClientAppointments(int clientId);
}
