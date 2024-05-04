package com.backendapiproject.searchandservice.infrastructure.dto.request;

import com.backendapiproject.searchandservice.infrastructure.dto.enums.RoleType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoleRequest {

    private RoleType roleType;

}
