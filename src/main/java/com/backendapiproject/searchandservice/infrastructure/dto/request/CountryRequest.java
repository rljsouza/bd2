package com.backendapiproject.searchandservice.infrastructure.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CountryRequest {

    @NotBlank
    private String name;
    @NotBlank
    private String namePt;
    @NotBlank
    private String abbreviation;
    private Integer countryCode;
}
