package com.backendapiproject.searchandservice.usecase;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface ScheduleServiceUseCase {
    void execute(Long serviceId, Long clientId, LocalDate date, LocalDateTime time);
}
