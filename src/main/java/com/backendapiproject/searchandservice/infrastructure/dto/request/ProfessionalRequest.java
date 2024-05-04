package com.backendapiproject.searchandservice.infrastructure.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProfessionalRequest{

    private String establishmentName;
    private String name;
    private AddressRequest address;
    private String CNPJ;
    private String CPF;
    private String phone;
    private String email;
}
