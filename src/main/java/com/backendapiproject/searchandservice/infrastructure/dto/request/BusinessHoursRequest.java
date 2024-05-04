package com.backendapiproject.searchandservice.infrastructure.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BusinessHoursRequest {

    private LocalDateTime openingTime;
    private LocalDateTime closingTime;
    private List<DayRequest> day;
    private List<LocalDate> exceptDates;

}
