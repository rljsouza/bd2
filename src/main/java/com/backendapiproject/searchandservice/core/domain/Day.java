package com.backendapiproject.searchandservice.core.domain;

public class Day {

    private Long id;
    private String name;

    public Day() {
    }

    public Day(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
