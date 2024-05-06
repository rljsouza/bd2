package com.backendapiproject.searchandservice.infrastructure.dto.response;

import com.backendapiproject.searchandservice.core.domain.enums.AppointmentStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class AppointmentResponse {
    private Long id;
    private ServiceResponse service;
    private CustomerResponse customerResponse;
    private LocalDate date;
    private LocalTime time;
    private AppointmentStatus status;

}
