package com.backendapiproject.searchandservice.infrastructure.dto.response;

import com.backendapiproject.searchandservice.core.domain.enums.ServiceStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ServiceResponse {

    private Long id;
    private Integer duration;
    private List<ServiceTypeResponse> serviceTypes;
    private String description;
    private BigDecimal value;
    private ServiceStatus status;
    private List<String> images;
    private List<BusinessHoursResponse> businessHours;
    private List<ReviewResponse> reviews;
}
