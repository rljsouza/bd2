package com.backendapiproject.searchandservice.infrastructure.dto.response;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ProfessionalResponse {

    private Long id;
    private String establishmentName;
    private String name;
    private AddressResponse address;
    private String CNPJ;
    private String CPF;
    private String phone;
    private String email;
    private List<ServiceResponse> services;

}
