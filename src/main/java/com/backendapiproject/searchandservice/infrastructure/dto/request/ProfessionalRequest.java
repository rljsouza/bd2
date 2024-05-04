package com.backendapiproject.searchandservice.infrastructure.dto.request;

import jakarta.validation.constraints.Email;
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
public class ProfessionalRequest{

    private String establishmentName;
    @NotBlank
    private String name;
    @NotNull
    private AddressRequest address;
    private String CNPJ;
    private String CPF;
    @NotBlank
    private String phone;
    @NotBlank
    @Email
    private String email;
    @NotNull
    private AccessDataRequest accessData;
}
