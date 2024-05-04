package com.backendapiproject.searchandservice.core.domain;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class BusinessHours {

    private Long id;
    private LocalTime openingTime;
    private LocalTime closingTime;
    private List<Day> days;
    private List<LocalDate> exceptDates;
    private Service service;

    public BusinessHours(Long id, LocalTime openingTime, LocalTime closingTime, List<Day> days, List<LocalDate> exceptDates, Service service) {
        this.id = id;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
        this.days = days;
        this.exceptDates = exceptDates;
        this.service = service;
    }

    public BusinessHours() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalTime getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(LocalTime openingTime) {
        this.openingTime = openingTime;
    }

    public LocalTime getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(LocalTime closingTime) {
        this.closingTime = closingTime;
    }

    public List<Day> getDays() {
        return days;
    }

    public void setDays(List<Day> days) {
        this.days = days;
    }

    public List<LocalDate> getExceptDates() {
        return exceptDates;
    }

    public void setExceptDates(List<LocalDate> exceptDates) {
        this.exceptDates = exceptDates;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }
}
