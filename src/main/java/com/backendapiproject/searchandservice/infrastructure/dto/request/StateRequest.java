package com.backendapiproject.searchandservice.infrastructure.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StateRequest {

    private String name;
    private String abbreviation;
    private BasicRequest country;
}
