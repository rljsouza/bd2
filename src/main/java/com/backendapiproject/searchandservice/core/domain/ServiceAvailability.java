package com.backendapiproject.searchandservice.core.domain;

import com.backendapiproject.searchandservice.core.domain.enums.DayOfWeek;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class ServiceAvailability{

    private Long serviceId;
    private Long professionalId;
    private DayOfWeek dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;
    private BigDecimal value;
    private List<LocalDate> exceptDates;

    public ServiceAvailability() {
    }

    public ServiceAvailability(Long serviceId, Long professionalId, DayOfWeek dayOfWeek, LocalTime startTime, LocalTime endTime, BigDecimal value, List<LocalDate> exceptDates) {
        this.serviceId = serviceId;
        this.professionalId = professionalId;
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;
        this.value = value;
        this.exceptDates = exceptDates;
    }


    public Long getServiceId() {
        return serviceId;
    }

    public List<LocalDate> getExceptDates() {
        return exceptDates;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public Long getProfessionalId() {
        return professionalId;
    }

    public void setProfessionalId(Long professionalId) {
        this.professionalId = professionalId;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public void setExceptDates(List<LocalDate> exceptDates) {
        this.exceptDates = exceptDates;
    }
}