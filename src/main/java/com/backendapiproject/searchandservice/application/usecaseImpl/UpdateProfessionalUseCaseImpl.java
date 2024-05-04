package com.backendapiproject.searchandservice.application.usecaseImpl;

import com.backendapiproject.searchandservice.application.gateway.ProfessionalGateway;
import com.backendapiproject.searchandservice.application.util.ObjectMapperUtil;
import com.backendapiproject.searchandservice.core.domain.Professional;
import com.backendapiproject.searchandservice.usecase.GetProfessionalByIdUseCase;
import com.backendapiproject.searchandservice.usecase.UpdateAddressUseCase;
import com.backendapiproject.searchandservice.usecase.UpdateProfessionalUseCase;

public class UpdateProfessionalUseCaseImpl implements UpdateProfessionalUseCase {

    private final ProfessionalGateway professionalGateway;
    private final GetProfessionalByIdUseCase getProfessionalById;
    private final UpdateAddressUseCase updateAddressUseCase;

    public UpdateProfessionalUseCaseImpl(ProfessionalGateway professionalGateway, GetProfessionalByIdUseCase getProfessionalById, UpdateAddressUseCase updateAddressUseCase) {
        this.professionalGateway = professionalGateway;
        this.getProfessionalById = getProfessionalById;
        this.updateAddressUseCase = updateAddressUseCase;
    }


    @Override
    public Professional execute(Professional professional, Long id) {
        var currentProfessional = getProfessionalById.execute(id);
        var address = updateAddressUseCase.execute(professional.getAddress(), professional.getId());
        ObjectMapperUtil.mapProperties(professional, currentProfessional);
        currentProfessional.setAddress(address);
        return professionalGateway.update(currentProfessional);
    }
}

