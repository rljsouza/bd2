package com.backendapiproject.searchandservice.usecase;

interface ScheduleServiceUseCase {
    void scheduleService(int serviceId, int clientId, String date, String time);
}
