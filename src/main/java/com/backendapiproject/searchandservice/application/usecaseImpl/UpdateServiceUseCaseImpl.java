package com.backendapiproject.searchandservice.application.usecaseImpl;

import com.backendapiproject.searchandservice.application.gateway.ServiceGateway;
import com.backendapiproject.searchandservice.application.util.ObjectMapperUtil;
import com.backendapiproject.searchandservice.core.domain.Service;
import com.backendapiproject.searchandservice.usecase.GetServiceByIdUseCase;
import com.backendapiproject.searchandservice.usecase.UpdateServiceUseCase;

public class  UpdateServiceUseCaseImpl implements UpdateServiceUseCase {

    private final ServiceGateway serviceGateway;
    private final GetServiceByIdUseCase getServiceByIdUseCase;

    public UpdateServiceUseCaseImpl(ServiceGateway serviceGateway, GetServiceByIdUseCase getServiceByIdUseCase) {
        this.serviceGateway = serviceGateway;
        this.getServiceByIdUseCase = getServiceByIdUseCase;
    }

    @Override
    public Service execute(Service service) {
        var currentService = getServiceByIdUseCase.execute(service.getId());
        ObjectMapperUtil.mapProperties(service, currentService);
        return serviceGateway.update(currentService);
    }
}
