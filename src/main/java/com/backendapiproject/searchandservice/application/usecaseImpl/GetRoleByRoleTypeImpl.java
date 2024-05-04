package com.backendapiproject.searchandservice.application.usecaseImpl;

import com.backendapiproject.searchandservice.application.gateway.RoleGateway;
import com.backendapiproject.searchandservice.core.domain.Role;
import com.backendapiproject.searchandservice.core.exception.NotFoundException;
import com.backendapiproject.searchandservice.infrastructure.dto.enums.RoleType;
import com.backendapiproject.searchandservice.usecase.GetRoleByRoleType;

public class GetRoleByRoleTypeImpl implements GetRoleByRoleType {

    private final RoleGateway roleGateway;

    public GetRoleByRoleTypeImpl(RoleGateway roleGateway) {
        this.roleGateway = roleGateway;
    }

    @Override
    public Role execute(RoleType roleType) {
        return roleGateway.getRoleByRoleType(roleType.name()).orElseThrow(() -> {
            throw new NotFoundException("RoleType não encontrado para o type: " + roleType);
        });
    }
}
