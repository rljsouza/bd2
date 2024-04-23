package com.backendapiproject.searchandservice.usecase;

import com.backendapiproject.searchandservice.core.domain.Appointment;

import java.util.List;

public interface ListCustomerAppointmentsByCustomerIdUseCase {
    List<Appointment> execute(Long customerId);
}
