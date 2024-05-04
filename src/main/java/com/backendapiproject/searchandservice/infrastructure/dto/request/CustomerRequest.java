package com.backendapiproject.searchandservice.infrastructure.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerRequest {

    private String name;
    private String gender;
    private String nationality;
    private String CPF;
    private String RG;
    private AddressRequest address;
    private String phone;
    private String email;
}