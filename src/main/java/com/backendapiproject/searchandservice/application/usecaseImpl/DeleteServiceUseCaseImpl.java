package com.backendapiproject.searchandservice.application.usecaseImpl;

import com.backendapiproject.searchandservice.application.gateway.ServiceGateway;
import com.backendapiproject.searchandservice.usecase.DeleteServiceByIdUseCase;
import com.backendapiproject.searchandservice.usecase.GetServiceByIdUseCase;

public class DeleteServiceUseCaseImpl implements DeleteServiceByIdUseCase {

    private final ServiceGateway serviceGateway;
    private final GetServiceByIdUseCase getServiceByIdUseCase;

    public DeleteServiceUseCaseImpl(ServiceGateway serviceGateway, GetServiceByIdUseCase getServiceByIdUseCase) {
        this.serviceGateway = serviceGateway;
        this.getServiceByIdUseCase = getServiceByIdUseCase;
    }

    @Override
    public void execute(Long id) {
        getServiceByIdUseCase.execute(id);
        serviceGateway.deleteById(id);
    }
}
