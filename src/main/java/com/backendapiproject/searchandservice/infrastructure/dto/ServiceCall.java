package com.backendapiproject.searchandservice.infrastructure.dto;

import com.backendapiproject.searchandservice.core.domain.enums.ServiceStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceCall {

    @NotNull
    private Integer serviceId;
    @NotBlank
    private ServiceStatus status;

}
