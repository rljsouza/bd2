package com.backendapiproject.searchandservice.application.usecaseImpl;

import com.backendapiproject.searchandservice.core.domain.Appointment;
import com.backendapiproject.searchandservice.usecase.ListProfessionalAppointmentsUByProfessionalIdUseCase;

import java.util.List;

public class ListProfessionalAppointmentsUByProfessionalIdUseCaseImpl implements ListProfessionalAppointmentsUByProfessionalIdUseCase {

    @Override
    public List<Appointment> execute(Long professionalId) {
        return List.of();
    }
}
