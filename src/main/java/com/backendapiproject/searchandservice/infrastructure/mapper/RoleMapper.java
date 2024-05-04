package com.backendapiproject.searchandservice.infrastructure.mapper;

import com.backendapiproject.searchandservice.core.domain.Role;
import com.backendapiproject.searchandservice.infrastructure.entity.RoleEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RoleMapper {

    private final ModelMapper mapper;

    public Role toRole(RoleEntity roleEntity){
        return mapper.map(roleEntity, Role.class);
    }
}
