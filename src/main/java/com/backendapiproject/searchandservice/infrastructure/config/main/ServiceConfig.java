package com.backendapiproject.searchandservice.infrastructure.config.main;

import com.backendapiproject.searchandservice.application.gateway.ServiceGateway;
import com.backendapiproject.searchandservice.application.usecaseImpl.DeleteServiceUseCaseImpl;
import com.backendapiproject.searchandservice.application.usecaseImpl.GetServiceByIdUseCaseImpl;
import com.backendapiproject.searchandservice.application.usecaseImpl.UpdateServiceUseCaseImpl;
import com.backendapiproject.searchandservice.usecase.DeleteServiceByIdUseCase;
import com.backendapiproject.searchandservice.usecase.GetServiceByIdUseCase;
import com.backendapiproject.searchandservice.usecase.UpdateServiceUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ServiceConfig {

    @Bean
    public GetServiceByIdUseCase getServiceByIdUseCase(ServiceGateway serviceGateway){
        return new GetServiceByIdUseCaseImpl(serviceGateway);
    }

    @Bean
    public DeleteServiceByIdUseCase deleteServiceByIdUseCase(ServiceGateway serviceGateway, GetServiceByIdUseCase getServiceByIdUseCase){
        return new DeleteServiceUseCaseImpl(serviceGateway, getServiceByIdUseCase);
    }

    @Bean
    public UpdateServiceUseCase updateServiceUseCase(ServiceGateway serviceGateway, GetServiceByIdUseCase getServiceByIdUseCase){
        return new UpdateServiceUseCaseImpl(serviceGateway, getServiceByIdUseCase);
    }

}
