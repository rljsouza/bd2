package com.backendapiproject.searchandservice.infrastructure.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentRequest {

    @NotNull
    private BasicRequest service;
    @NotNull
    private BasicRequest customer;
    @NotNull
    private LocalDate date;
    @NotNull
    private LocalTime time;

}
