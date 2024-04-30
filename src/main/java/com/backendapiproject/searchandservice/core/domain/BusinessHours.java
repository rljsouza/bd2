package com.backendapiproject.searchandservice.core.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class BusinessHours {

    private Long id;
    private LocalDateTime openingTime;
    private LocalDateTime closingTime;
    private List<Day> day;
    private List<LocalDate> exceptDates;

    public BusinessHours() {
    }

    public BusinessHours(Long id, LocalDateTime openingTime, LocalDateTime closingTime, List<Day> day, List<LocalDate> exceptDates) {
        this.id = id;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
        this.day = day;
        this.exceptDates = exceptDates;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<Day> getDay() {
        return day;
    }

    public void setDay(List<Day> day) {
        this.day = day;
    }

    public List<LocalDate> getExceptDates() {
        return exceptDates;
    }

    public void setExceptDate(List<LocalDate> exceptDates) {
        this.exceptDates = exceptDates;
    }
}
