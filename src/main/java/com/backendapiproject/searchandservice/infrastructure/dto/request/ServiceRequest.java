package com.backendapiproject.searchandservice.infrastructure.dto.request;


import com.backendapiproject.searchandservice.infrastructure.dto.enums.ServiceStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ServiceRequest {

    @NotNull
    private Integer duration;
    @NotNull
    private List<BasicRequest> serviceTypes;
    @NotBlank
    private String description;
    @NotNull
    private BigDecimal value;
    @NotNull
    private ServiceStatus status;
    private List<String> images;
    @NotNull
    private List<BusinessHoursRequest> businessHours;

}
