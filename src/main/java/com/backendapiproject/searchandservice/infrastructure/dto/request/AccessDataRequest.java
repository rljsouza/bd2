package com.backendapiproject.searchandservice.infrastructure.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AccessDataRequest {

    @NotBlank
    private String username;
    @NotBlank
    private String password;
    private Set<RoleRequest> roles;
}
