package com.backendapiproject.searchandservice.application.usecaseImpl;

import com.backendapiproject.searchandservice.application.gateway.ProfessionalGateway;
import com.backendapiproject.searchandservice.core.domain.Professional;
import com.backendapiproject.searchandservice.usecase.GetAllProfessionalsUseCase;

import java.util.List;

public class GetAllProfessionalsUseCaseImpl implements GetAllProfessionalsUseCase {

    private final ProfessionalGateway professionalGateway;

    public GetAllProfessionalsUseCaseImpl(ProfessionalGateway professionalGateway) {
        this.professionalGateway = professionalGateway;
    }

    @Override
    public List<Professional> execute() {
        return professionalGateway.findAll();
    }
}
