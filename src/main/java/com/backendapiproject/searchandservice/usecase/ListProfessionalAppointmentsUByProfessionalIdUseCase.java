package com.backendapiproject.searchandservice.usecase;

interface ListProfessionalAppointmentsUseCase {
    List<Appointment> listProfessionalAppointments(int professionalId);
}
