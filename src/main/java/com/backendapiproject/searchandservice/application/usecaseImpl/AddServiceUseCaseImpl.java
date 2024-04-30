package com.backendapiproject.searchandservice.application.usecaseImpl;

import com.backendapiproject.searchandservice.application.gateway.ServiceGateway;
import com.backendapiproject.searchandservice.core.domain.Professional;
import com.backendapiproject.searchandservice.core.domain.Service;
import com.backendapiproject.searchandservice.usecase.AddServiceUseCase;
import com.backendapiproject.searchandservice.usecase.GetProfessionalByIdUseCase;
import com.backendapiproject.searchandservice.usecase.UpdateProfessionalUseCase;

public class AddServiceUseCaseImpl implements AddServiceUseCase {

    private final ServiceGateway serviceGateway;
    private final GetProfessionalByIdUseCase getProfessionalById;
    private final UpdateProfessionalUseCase updateProfessionalUseCase;

    public AddServiceUseCaseImpl(ServiceGateway serviceGateway, GetProfessionalByIdUseCase getProfessionalById, UpdateProfessionalUseCase updateProfessionalUseCase) {
        this.serviceGateway = serviceGateway;
        this.getProfessionalById = getProfessionalById;
        this.updateProfessionalUseCase = updateProfessionalUseCase;
    }

    @Override
    public Professional execute(Service service, Long professionalId) {
        var professional = getProfessionalById.execute(professionalId);
        var newService = serviceGateway.save(service);
        professional.getServices().add(newService);
        return updateProfessionalUseCase.execute(professional);
    };
}
