package com.backendapiproject.searchandservice.application.usecaseImpl;

import com.backendapiproject.searchandservice.core.domain.Appointment;

import com.backendapiproject.searchandservice.application.gateway.AppointmentGateWay;
import com.backendapiproject.searchandservice.core.domain.enums.AppointmentStatus;
import com.backendapiproject.searchandservice.core.exception.NotFoundException;
import com.backendapiproject.searchandservice.usecase.AppointmentUseCase;
import com.backendapiproject.searchandservice.usecase.GetCustomerByIdUseCase;
import com.backendapiproject.searchandservice.usecase.GetServiceByIdUseCase;


public class AppointmentUseCaseImpl implements AppointmentUseCase {

    private final AppointmentGateWay appointmentGateWay;
    private final GetCustomerByIdUseCase getCustomerByIdUseCase;
    private final GetServiceByIdUseCase getServiceByIdUseCase;


    public AppointmentUseCaseImpl(AppointmentGateWay appointmentGateWay, GetCustomerByIdUseCase getCustomerByIdUseCase, GetServiceByIdUseCase getServiceByIdUseCase) {
        this.appointmentGateWay = appointmentGateWay;
        this.getCustomerByIdUseCase = getCustomerByIdUseCase;
        this.getServiceByIdUseCase = getServiceByIdUseCase;
    }

    @Override
    public Appointment cancel(Long id) {
        var appointment = this.getAppointmentById(id);
        appointment.setStatus(AppointmentStatus.CANCELED);
        return appointmentGateWay.cancel(appointment);
    }

    @Override
    public Appointment confirm(Long id) {
        var appointment = this.getAppointmentById(id);
        appointment.setStatus(AppointmentStatus.CONFIRMED);
        return appointmentGateWay.confirm(appointment);
    }

    @Override
    public Appointment create(Appointment appointment) {
        var customer = getCustomerByIdUseCase.execute(appointment.getCustomer().getId());
        var service = getServiceByIdUseCase.execute(appointment.getService().getId());
        appointment.setCustomer(customer);
        appointment.setService(service);
        appointment.setStatus(AppointmentStatus.SCHEDULED);
        return appointment;
    }

    @Override
    public Appointment getAppointmentById(Long id) {
        return appointmentGateWay.getAppointmentById(id).orElseThrow(() -> {
            throw new NotFoundException("Agendamento não encontrado. ID "+ id);
        });
    }
}
