package com.backendapiproject.searchandservice.infrastructure.controller;


import com.backendapiproject.searchandservice.core.domain.Appointment;
import com.backendapiproject.searchandservice.infrastructure.annotation.Authorize;
import com.backendapiproject.searchandservice.infrastructure.dto.request.AppointmentRequest;
import com.backendapiproject.searchandservice.infrastructure.dto.response.AppointmentResponse;
import com.backendapiproject.searchandservice.infrastructure.mapper.AppointmentMapper;
import com.backendapiproject.searchandservice.usecase.AppointmentUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/v1/api/appointment")
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentUseCase appointmentUseCase;
    private final AppointmentMapper mapper;

    @PostMapping("/create")
    public ResponseEntity<AppointmentResponse> createAppointment(@RequestBody @Valid AppointmentRequest request) {
        var createdAppointment = appointmentUseCase.create(mapper.toAppointment(request));
        return new ResponseEntity<>(mapper.toAppointmentResponse(createdAppointment), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppointmentResponse> getAppointmentById(@PathVariable("id") Long id) {
        var appointment = appointmentUseCase.getAppointmentById(id);
        return new ResponseEntity<>(mapper.toAppointmentResponse(appointment), HttpStatus.OK);

    }

    @Authorize(value = "ROLE_USER")
    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<AppointmentResponse>> listByCustomerId(@PathVariable("customerId") Long customerId) {
        var appointment = appointmentUseCase.listCustomerAppointmentsByCustomerId(customerId);
        return new ResponseEntity<>(mapper.toAppointmentResponse(appointment), HttpStatus.OK);

    }

    @Authorize(value = "ROLE_PROFESSIONAL")
    @GetMapping("/professional/{professionalId}/service/{serviceId}")
    public ResponseEntity<List<AppointmentResponse>> listByServiceId(@PathVariable("professionalId") Long professionalId, @PathVariable("serviceId") Long serviceId) {
        var appointment = appointmentUseCase.listServiceAppointmentsUByServiceId(professionalId, serviceId);
        return new ResponseEntity<>(mapper.toAppointmentResponse(appointment), HttpStatus.OK);

    }

    @PutMapping("/{id}/confirm")
    public ResponseEntity<AppointmentResponse> confirmAppointment(@PathVariable("id") Long id) {
        var confirmedAppointment = appointmentUseCase.confirm(id);
        return new ResponseEntity<>(mapper.toAppointmentResponse(confirmedAppointment), HttpStatus.OK);
    }

    @PutMapping("/{id}/cancel")
    public ResponseEntity<Appointment> cancelAppointment(@PathVariable("id") Long id) {
        var canceledAppointment = appointmentUseCase.cancel(id);
        return new ResponseEntity<>(canceledAppointment, HttpStatus.OK);
    }



}
