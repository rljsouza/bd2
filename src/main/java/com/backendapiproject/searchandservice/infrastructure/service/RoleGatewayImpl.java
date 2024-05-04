package com.backendapiproject.searchandservice.infrastructure.service;

import com.backendapiproject.searchandservice.application.gateway.RoleGateway;
import com.backendapiproject.searchandservice.core.domain.Role;
import com.backendapiproject.searchandservice.infrastructure.entity.enums.RoleType;
import com.backendapiproject.searchandservice.infrastructure.mapper.RoleMapper;
import com.backendapiproject.searchandservice.infrastructure.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoleGatewayImpl implements RoleGateway {

    private final RoleRepository roleRepository;
    private final RoleMapper mapper;

    @Override
    public Optional<Role> getRoleByRoleType(String roleType) {
        return roleRepository.findByRoleType(RoleType.valueOf(roleType)).map(mapper::toRole);
    }
}
