package com.backendapiproject.searchandservice.infrastructure.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class BusinessHoursResponse {

    private Long id;
    private LocalTime openingTime;
    private LocalTime closingTime;
    private List<DayResponse> days;
    private List<LocalDate> exceptDates;
    private ServiceResponse service;


}
