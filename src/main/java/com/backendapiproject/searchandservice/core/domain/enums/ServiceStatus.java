package com.backendapiproject.searchandservice.core.domain.enums;

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
