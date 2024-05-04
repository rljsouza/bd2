package com.backendapiproject.searchandservice.infrastructure.dto.request;

import com.backendapiproject.searchandservice.core.domain.enums.AppointmentStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentRequest {

    private BasicRequest service;
    private BasicRequest customer;
    private LocalDate date;
    private LocalDateTime time;
    private AppointmentStatus status;

}
