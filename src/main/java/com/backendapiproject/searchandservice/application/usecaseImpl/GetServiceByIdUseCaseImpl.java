package com.backendapiproject.searchandservice.application.usecaseImpl;

import com.backendapiproject.searchandservice.application.gateway.ServiceGateway;
import com.backendapiproject.searchandservice.core.domain.Service;
import com.backendapiproject.searchandservice.core.exception.NotFoundException;
import com.backendapiproject.searchandservice.usecase.GetServiceByIdUseCase;

public class GetServiceByIdUseCaseImpl implements GetServiceByIdUseCase {

    private final ServiceGateway serviceGateway;

    public GetServiceByIdUseCaseImpl(ServiceGateway serviceGateway) {
        this.serviceGateway = serviceGateway;
    }

    @Override
    public Service execute(Long id) {
        return serviceGateway.findById(id).orElseThrow(()-> new NotFoundException("Service não encontrado para o ID: " + id));
    }
}
