package com.backendapiproject.searchandservice.core.domain;

import com.backendapiproject.searchandservice.core.domain.enums.ServiceStatus;
import com.backendapiproject.searchandservice.infrastructure.entity.ProfessionalEntity;

import java.math.BigDecimal;
import java.util.List;

public class Service {

    private Long id;
    private Integer duration;
    private List<ServiceType> serviceTypes;
    private String description;
    private BigDecimal value;
    private ServiceStatus status;
    private List<String> images;
    private List<BusinessHours> businessHours;
    private List<Review> reviews;
    private Professional professional;



    public Service(Long id, List<String> images, BigDecimal value, ServiceStatus status, String description, Integer duration, List<ServiceType> serviceTypes, List<BusinessHours> businessHours, List<Review> reviews, Professional professional) {
        this.id = id;
        this.images = images;
        this.value = value;
        this.status = status;
        this.description = description;
        this.duration = duration;
        this.serviceTypes = serviceTypes;
        this.businessHours = businessHours;
        this.reviews = reviews;
        this.professional = professional;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public List<ServiceType> getServiceTypes() {
        return serviceTypes;
    }

    public void setServiceTypes(List<ServiceType> serviceTypes) {
        this.serviceTypes = serviceTypes;
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

    public List<BusinessHours> getBusinessHours() {
        return businessHours;
    }

    public void setBusinessHours(List<BusinessHours> businessHours) {
        this.businessHours = businessHours;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public Professional getProfessional() {
        return professional;

    }

    public void setProfessional(Professional professional) {
        this.professional = professional;
    }
}
