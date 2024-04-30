package com.backendapiproject.searchandservice.infrastructure.entity.enums;

public enum ServiceStatus {
    OPEN("Open"),
    CLOSED("Closed");

    private final String description;

    ServiceStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
