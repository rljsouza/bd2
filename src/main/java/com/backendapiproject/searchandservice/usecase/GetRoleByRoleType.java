package com.backendapiproject.searchandservice.usecase;

import com.backendapiproject.searchandservice.core.domain.Role;
import com.backendapiproject.searchandservice.infrastructure.dto.enums.RoleType;

public interface GetRoleByRoleType {
    Role execute(RoleType roleType);
}
