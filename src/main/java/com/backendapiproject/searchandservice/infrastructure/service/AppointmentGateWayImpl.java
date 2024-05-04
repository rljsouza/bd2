package com.backendapiproject.searchandservice.infrastructure.service;

import com.backendapiproject.searchandservice.application.gateway.AppointmentGateWay;
import com.backendapiproject.searchandservice.core.domain.Appointment;
import com.backendapiproject.searchandservice.infrastructure.mapper.AppointmentMapper;
import com.backendapiproject.searchandservice.infrastructure.repository.AppointmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AppointmentGateWayImpl implements AppointmentGateWay {

    private final AppointmentRepository repository;
    private final AppointmentMapper mapper;


    @Override
    public Appointment cancel(Appointment appointment) {
        return mapper.toAppointment(repository.save(mapper.toAppointment(appointment)));
    }

    @Override
    public Appointment confirm(Appointment appointment) {
        return mapper.toAppointment(repository.save(mapper.toAppointment(appointment)));
    }

    @Override
    public Appointment create(Appointment appointment) {
        return mapper.toAppointment(repository.save(mapper.toAppointment(appointment)));
    }

    @Override
    public Optional<Appointment> getAppointmentById(Long id) {
        var appointment = repository.findById(id);
        return appointment.map(mapper::toAppointment);
    }
}
