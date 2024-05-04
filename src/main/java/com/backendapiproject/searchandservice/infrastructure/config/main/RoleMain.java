package com.backendapiproject.searchandservice.infrastructure.config.main;

import com.backendapiproject.searchandservice.application.gateway.RoleGateway;
import com.backendapiproject.searchandservice.application.usecaseImpl.GetRoleByRoleTypeImpl;
import com.backendapiproject.searchandservice.usecase.GetRoleByRoleType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RoleMain {


    @Bean
    public GetRoleByRoleType getRoleByRoleType(RoleGateway roleGateway){
        return new GetRoleByRoleTypeImpl(roleGateway);
    }
}
