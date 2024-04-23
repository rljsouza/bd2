package com.backendapiproject.searchandservice.usecase;

import java.time.LocalDate;
import java.time.LocalDateTime;

interface ScheduleServiceUseCase {
    void execute(Long serviceId, Long clientId, LocalDate date, LocalDateTime time);
}
