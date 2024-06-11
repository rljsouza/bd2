package com.backendapiproject.searchandservice.infrastructure.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentReportDTO {

    private Long appointmentId;
    private Long customerId;
    private String customerName;
    private String serviceDescription;
    private LocalDate appointmentDate;
    private LocalTime appointmentTime;
    private Long professionalId;
    private String professionalName;

}
