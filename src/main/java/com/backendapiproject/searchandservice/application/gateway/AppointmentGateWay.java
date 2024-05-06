package com.backendapiproject.searchandservice.application.gateway;

import com.backendapiproject.searchandservice.core.domain.Appointment;

import java.util.List;
import java.util.Optional;

public interface AppointmentGateWay {

    Appointment cancel(Appointment appointment);

    Appointment confirm(Appointment appointment);

    Appointment create(Appointment appointment);

    Optional<Appointment> getAppointmentById(Long id);

    List<Appointment> listCustomerAppointmentsByCustomerId(Long customerId);

    List<Appointment> listServiceAppointmentsUByServiceId(Long professionalId);
}
