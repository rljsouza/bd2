package com.backendapiproject.searchandservice.core.domain;

import com.backendapiproject.searchandservice.core.domain.enums.DayOfWeek;

public class Day {

    private Long id;
    private DayOfWeek name;

    public Day(Long id, DayOfWeek name) {
        this.id = id;
        this.name = name;
    }

    public Day() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DayOfWeek getName() {
        return name;
    }

    public void setName(DayOfWeek name) {
        this.name = name;
    }
}
