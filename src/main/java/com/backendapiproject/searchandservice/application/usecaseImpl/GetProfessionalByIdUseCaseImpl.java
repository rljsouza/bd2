package com.backendapiproject.searchandservice.application.usecaseImpl;

import com.backendapiproject.searchandservice.application.gateway.ProfessionalGateway;
import com.backendapiproject.searchandservice.core.domain.Professional;
import com.backendapiproject.searchandservice.core.exception.NotFoundException;
import com.backendapiproject.searchandservice.usecase.GetProfessionalByIdUseCase;

public class GetProfessionalByIdUseCaseImpl implements GetProfessionalByIdUseCase {

    private final ProfessionalGateway professionalGateway;

    public GetProfessionalByIdUseCaseImpl(ProfessionalGateway professionalGateway) {
        this.professionalGateway = professionalGateway;
    }

    @Override
    public Professional execute(Long id) {
        return professionalGateway.findById(id)
                .orElseThrow(() -> new NotFoundException("Profissional não encontrado para o ID: " + id));
    }
}
