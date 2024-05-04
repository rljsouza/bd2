package com.backendapiproject.searchandservice.application.usecaseImpl;

import com.backendapiproject.searchandservice.application.gateway.ProfessionalGateway;
import com.backendapiproject.searchandservice.core.domain.Service;
import com.backendapiproject.searchandservice.usecase.GetProfessionalByIdUseCase;
import com.backendapiproject.searchandservice.usecase.GetServiceByProfessionalIdUseCase;

import java.util.List;

public class GetServiceByProfessionalIdUseCaseImpl implements GetServiceByProfessionalIdUseCase {

    private final ProfessionalGateway professionalGateway;
    private final GetProfessionalByIdUseCase getProfessionalByIdUseCase;

    public GetServiceByProfessionalIdUseCaseImpl(ProfessionalGateway professionalGateway, GetProfessionalByIdUseCase getProfessionalByIdUseCase) {
        this.professionalGateway = professionalGateway;
        this.getProfessionalByIdUseCase = getProfessionalByIdUseCase;
    }

    @Override
    public List<Service> execute(Long professionalId) {
        var professional = getProfessionalByIdUseCase.execute(professionalId);
       return professional.getServices();
    }
}
