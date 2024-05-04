package com.backendapiproject.searchandservice.infrastructure.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddressRequest {

    @NotBlank
    private String street;
    private String complement;
    @NotNull
    private Integer number;
    @NotBlank
    private String neighborhood;
    private String zipCode;
    @NotNull
    private BasicRequest city;

}
