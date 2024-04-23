package com.backendapiproject.searchandservice.usecase;

import com.backendapiproject.searchandservice.core.domain.Appointment;

import java.util.List;

interface ListProfessionalAppointmentsUByProfessionalIdUseCase {
    List<Appointment> execute(Long professionalId);
}
