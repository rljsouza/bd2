package com.backendapiproject.searchandservice.infrastructure.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfessionalReviewDTO {
    private Long reviewId;
    private String reviewDescription;
    private Long customerId;
    private Long serviceId;
    private Long professionalId;
    private String professionalName;
    private String serviceDescription;
    private String serviceTypeName;

}
