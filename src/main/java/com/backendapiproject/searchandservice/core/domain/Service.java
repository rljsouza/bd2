package com.backendapiproject.searchandservice.core.domain;

import com.backendapiproject.searchandservice.core.domain.enums.ServiceStatus;

import java.math.BigDecimal;

public class Service {
    private Long id;
    private Professional professional;
    private Integer duration;
    private Service service;
    private String description;
    private BigDecimal value;
    private ServiceStatus status;
    private String image;

    public Service(Long id, String image, BigDecimal value, ServiceStatus status, String description, Integer duration, Professional professional, Service service) {
        this.id = id;
        this.image = image;
        this.value = value;
        this.status = status;
        this.description = description;
        this.duration = duration;
        this.professional = professional;
        this.service = service;
    }

    public Service() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Professional getProfessional() {
        return professional;
    }

    public void setProfessional(Professional professional) {
        this.professional = professional;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public ServiceStatus getStatus() {
        return status;
    }

    public void setStatus(ServiceStatus status) {
        this.status = status;
    }
}
