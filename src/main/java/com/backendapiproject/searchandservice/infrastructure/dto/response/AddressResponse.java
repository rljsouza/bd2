package com.backendapiproject.searchandservice.infrastructure.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class AddressResponse {

    private Long id;
    private String street;
    private String complement;
    private Integer number;
    private String neighborhood;
    private String zipCode;
    private CityResponse city;

}
