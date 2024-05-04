package com.backendapiproject.searchandservice.infrastructure.config.main;

import com.backendapiproject.searchandservice.application.gateway.BusinessHoursUseCaseGateway;
import com.backendapiproject.searchandservice.application.usecaseImpl.BusinessHoursUseCaseImpl;
import com.backendapiproject.searchandservice.usecase.BusinessHoursUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BusinessHoursMain {

    @Bean
    public BusinessHoursUseCase businessHoursUseCase(BusinessHoursUseCaseGateway caseGateway){
        return new BusinessHoursUseCaseImpl(caseGateway);
    }
}
