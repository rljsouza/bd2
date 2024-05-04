package com.backendapiproject.searchandservice.application.usecaseImpl;

import com.backendapiproject.searchandservice.application.gateway.ServiceGateway;
import com.backendapiproject.searchandservice.usecase.DeleteServiceByIdUseCase;
import com.backendapiproject.searchandservice.usecase.GetProfessionalByIdUseCase;
import com.backendapiproject.searchandservice.usecase.GetServiceByIdUseCase;

public class DeleteServiceUseCaseImpl implements DeleteServiceByIdUseCase {

    private final ServiceGateway serviceGateway;
    private final GetServiceByIdUseCase getServiceByIdUseCase;
    private final GetProfessionalByIdUseCase getProfessionalByIdUseCase;

    public DeleteServiceUseCaseImpl(ServiceGateway serviceGateway, GetServiceByIdUseCase getServiceByIdUseCase, GetProfessionalByIdUseCase getProfessionalByIdUseCase) {
        this.serviceGateway = serviceGateway;
        this.getServiceByIdUseCase = getServiceByIdUseCase;
        this.getProfessionalByIdUseCase = getProfessionalByIdUseCase;
    }

    @Override
    public void execute(Long professionalId, Long id) {
        getServiceByIdUseCase.execute(id);
        getProfessionalByIdUseCase.execute(professionalId);
        serviceGateway.deleteById(id);
    }
}
