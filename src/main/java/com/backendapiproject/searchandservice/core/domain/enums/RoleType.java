package com.backendapiproject.searchandservice.core.domain.enums;

public enum RoleType {
    ROLE_ADMIN("System Administrator"),
    ROLE_PROFESSIONAL("Professional"),
    ROLE_USER("Standard User");

    private final String description;

    RoleType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
