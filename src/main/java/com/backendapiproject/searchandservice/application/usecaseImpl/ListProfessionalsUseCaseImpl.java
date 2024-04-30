package com.backendapiproject.searchandservice.application.usecaseImpl;

import com.backendapiproject.searchandservice.application.gateway.ProfessionalGateway;
import com.backendapiproject.searchandservice.core.domain.Professional;
import com.backendapiproject.searchandservice.usecase.ListProfessionalsUseCase;

import java.util.List;

public class ListProfessionalsUseCaseImpl implements ListProfessionalsUseCase {

    private final ProfessionalGateway professionalGateway;

    public ListProfessionalsUseCaseImpl(ProfessionalGateway professionalGateway) {
        this.professionalGateway = professionalGateway;
    }

    @Override
    public List<Professional> execute() {
        return professionalGateway.findAll();
    }
}
