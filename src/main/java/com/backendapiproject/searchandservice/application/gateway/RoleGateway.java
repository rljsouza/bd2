package com.backendapiproject.searchandservice.application.gateway;

import com.backendapiproject.searchandservice.core.domain.Role;
import com.backendapiproject.searchandservice.infrastructure.dto.enums.RoleType;

import java.util.Optional;

public interface RoleGateway {

    Optional<Role> getRoleByRoleType(String roleType);
}
