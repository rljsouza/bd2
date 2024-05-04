package com.backendapiproject.searchandservice.infrastructure.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CityRequest {

    @NotBlank
    private String name;
    private String abbreviation;
    @NotNull
    private BasicRequest state;
    private String areaCode;


}
