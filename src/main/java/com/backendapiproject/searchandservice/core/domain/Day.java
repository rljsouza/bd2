package com.backendapiproject.searchandservice.core.domain;

import com.backendapiproject.searchandservice.core.domain.enums.DayOfWeek;
import lombok.Data;

@Data
public class Day {

    private Long id;
    private DayOfWeek name;

    public Day(Long id, DayOfWeek name) {
        this.id = id;
        this.name = name;
    }

    public Day(DayOfWeek name) {
        this.name = name;
    }

    public Day() {
    }

    public Day(com.backendapiproject.searchandservice.infrastructure.dto.enums.DayOfWeek dayOfWeek) {
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
