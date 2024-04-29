package com.backendapiproject.searchandservice.application.usecaseImpl;

import com.backendapiproject.searchandservice.application.gateway.ProfessionalGateway;
import com.backendapiproject.searchandservice.core.domain.Professional;
import com.backendapiproject.searchandservice.usecase.CreateAddressUseCase;
import com.backendapiproject.searchandservice.usecase.CreateProfessionalUseCase;

public class CreateProfessionalUseCaseImpl implements CreateProfessionalUseCase {

    private final ProfessionalGateway professionalGateway;
    private final CreateAddressUseCase createAddressUseCase;

    public CreateProfessionalUseCaseImpl(ProfessionalGateway professionalGateway, CreateAddressUseCase createAddressUseCase) {
        this.professionalGateway = professionalGateway;
        this.createAddressUseCase = createAddressUseCase;
    }

    @Override
    public Professional execute(Professional professional) {
        var address =  createAddressUseCase.execute(professional.getAddress());
        professional.setAddress(address);
        return professionalGateway.save(professional);
    }
}
