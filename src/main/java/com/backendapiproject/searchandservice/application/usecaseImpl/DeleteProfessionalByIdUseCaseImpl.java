package com.backendapiproject.searchandservice.application.usecaseImpl;

import com.backendapiproject.searchandservice.application.gateway.ProfessionalGateway;
import com.backendapiproject.searchandservice.usecase.DeleteProfessionalByIdUseCase;
import com.backendapiproject.searchandservice.usecase.GetProfessionalByIdUseCase;

public class DeleteProfessionalByIdUseCaseImpl implements DeleteProfessionalByIdUseCase {

    private final ProfessionalGateway professionalGateway;
    private final GetProfessionalByIdUseCase getProfessionalById;

    public DeleteProfessionalByIdUseCaseImpl(ProfessionalGateway professionalGateway, GetProfessionalByIdUseCase getProfessionalById) {
        this.professionalGateway = professionalGateway;
        this.getProfessionalById = getProfessionalById;
    }

    @Override
    public void execute(Long id) {
        getProfessionalById.execute(id);
        professionalGateway.delete(id);
    }
}
