package com.backendapiproject.searchandservice.infrastructure.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusinessHoursRequest {

    private LocalTime openingTime;
    private LocalTime closingTime;
    private List<DayRequest> days;
    private List<LocalDate> exceptDates;

}
