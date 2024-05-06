package com.backendapiproject.searchandservice.infrastructure.dto.response;

import com.backendapiproject.searchandservice.core.domain.AccessData;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class CustomerResponse {

    private Long id;
    private String name;
    private String gender;
    private String nationality;
    private String CPF;
    private String RG;
    private AddressResponse address;
    private String phone;
    private String email;

}