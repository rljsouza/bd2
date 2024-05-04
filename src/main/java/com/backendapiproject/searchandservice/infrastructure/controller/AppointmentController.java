package com.backendapiproject.searchandservice.infrastructure.controller;


import com.backendapiproject.searchandservice.core.domain.Appointment;
import com.backendapiproject.searchandservice.infrastructure.dto.request.AppointmentRequest;
import com.backendapiproject.searchandservice.infrastructure.mapper.AppointmentMapper;
import com.backendapiproject.searchandservice.usecase.AppointmentUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api/appointment")
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentUseCase appointmentUseCase;
    private final AppointmentMapper mapper;

    @PostMapping("/create")
    public ResponseEntity<Appointment> createAppointment(@RequestBody  @Valid AppointmentRequest request) {
        Appointment createdAppointment = appointmentUseCase.create(mapper.toAppointment(request));
        return new ResponseEntity<>(createdAppointment, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Appointment> getAppointmentById(@PathVariable("id") Long id) {
        Appointment appointment = appointmentUseCase.getAppointmentById(id);
        return new ResponseEntity<>(appointment, HttpStatus.OK);

    }

    @PutMapping("/{id}/confirm")
    public ResponseEntity<Appointment> confirmAppointment(@PathVariable("id") Long id) {
        Appointment confirmedAppointment = appointmentUseCase.confirm(id);
        return new ResponseEntity<>(confirmedAppointment, HttpStatus.OK);
    }

    @PutMapping("/{id}/cancel")
    public ResponseEntity<Appointment> cancelAppointment(@PathVariable("id") Long id) {
        Appointment canceledAppointment = appointmentUseCase.cancel(id);
        return new ResponseEntity<>(canceledAppointment, HttpStatus.OK);
    }
}
