package com.backendapiproject.searchandservice.infrastructure.dto.request;


import com.backendapiproject.searchandservice.infrastructure.dto.enums.ServiceStatus;

import java.math.BigDecimal;
import java.util.List;

public class ServiceRequest {

    private Integer duration;
    private List<ServiceTypeRequest> serviceTypes;
    private String description;
    private BigDecimal value;
    private ServiceStatus status;
    private List<String> images;
    private List<BusinessHoursRequest> businessHours;

}
