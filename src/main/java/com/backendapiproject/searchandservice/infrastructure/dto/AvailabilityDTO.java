package com.backendapiproject.searchandservice.infrastructure.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AvailabilityDTO {

    private Long professionalId;
    private String professionalName;
    private Long serviceId;
    private String serviceDescription;
    private Integer totalScheduledDuration;
    private Integer newServiceDuration;
    private Integer totalWorkingMinutes;
    private Boolean availability;
    private  String serviceTypeName;

}