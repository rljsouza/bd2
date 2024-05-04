package com.backendapiproject.searchandservice.core.domain;

import com.backendapiproject.searchandservice.core.domain.enums.AppointmentStatus;

import java.time.LocalDate;
import java.time.LocalTime;

public class Appointment {
    private Long id;
    private Service service;
    private Customer customer;
    private LocalDate date;
    private LocalTime time;
    private AppointmentStatus status;

    public Appointment() {
    }

    public Appointment(Long id, Service service, Customer customer, LocalDate date, LocalTime time, AppointmentStatus status) {
        this.id = id;
        this.service = service;
        this.customer = customer;
        this.date = date;
        this.time = time;
        this.status = status;
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public AppointmentStatus getStatus() {
        return status;
    }

    public void setStatus(AppointmentStatus status) {
        this.status = status;
    }
}
