package com.backendapiproject.searchandservice.infrastructure.dto.response;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class CountryResponse {

    private Long id;
    private String name;
    private String namePt;
    private String abbreviation;
    private Integer countryCode;


}
