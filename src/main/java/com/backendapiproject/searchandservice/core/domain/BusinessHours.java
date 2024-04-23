package com.backendapiproject.searchandservice.core.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class BusinessHours {
    private Long id;
    private Service service;
    private LocalDateTime openingTime;
    private LocalDateTime closingTime;
    private Day day;
    private LocalDate date;

    public BusinessHours() {
    }

    public BusinessHours(Long id, Service service, LocalDateTime openingTime, LocalDateTime closingTime, Day day, LocalDate date) {
        this.id = id;
        this.service = service;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
        this.day = day;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public LocalDateTime getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(LocalDateTime openingTime) {
        this.openingTime = openingTime;
    }

    public LocalDateTime getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(LocalDateTime closingTime) {
        this.closingTime = closingTime;
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
