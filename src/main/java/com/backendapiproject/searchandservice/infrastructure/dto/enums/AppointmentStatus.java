package com.backendapiproject.searchandservice.infrastructure.dto.enums;

public enum AppointmentStatus {
    CANCELED("Canceled"),
    SCHEDULED("Scheduled"),
    CONFIRMED("Confirmed");

    private final String description;

    AppointmentStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
