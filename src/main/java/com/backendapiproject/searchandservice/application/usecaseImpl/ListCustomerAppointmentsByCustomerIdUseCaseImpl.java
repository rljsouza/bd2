package com.backendapiproject.searchandservice.application.usecaseImpl;

import com.backendapiproject.searchandservice.core.domain.Appointment;
import com.backendapiproject.searchandservice.usecase.ListCustomerAppointmentsByCustomerIdUseCase;

import java.util.List;

public class ListCustomerAppointmentsByCustomerIdUseCaseImpl implements ListCustomerAppointmentsByCustomerIdUseCase {

    @Override
    public List<Appointment> execute(Long customerId) {
        return List.of();
    }
}
