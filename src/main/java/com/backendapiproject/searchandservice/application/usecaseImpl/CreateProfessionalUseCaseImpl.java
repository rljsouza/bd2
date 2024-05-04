package com.backendapiproject.searchandservice.application.usecaseImpl;

import com.backendapiproject.searchandservice.application.gateway.ProfessionalGateway;
import com.backendapiproject.searchandservice.core.domain.Professional;
import com.backendapiproject.searchandservice.infrastructure.dto.enums.RoleType;
import com.backendapiproject.searchandservice.usecase.CreateAddressUseCase;
import com.backendapiproject.searchandservice.usecase.CreateProfessionalUseCase;
import com.backendapiproject.searchandservice.usecase.GetRoleByRoleType;

public class CreateProfessionalUseCaseImpl implements CreateProfessionalUseCase {

    private final ProfessionalGateway professionalGateway;
    private final CreateAddressUseCase createAddressUseCase;
    private final GetRoleByRoleType getRoleByRoleType;

    public CreateProfessionalUseCaseImpl(ProfessionalGateway professionalGateway, CreateAddressUseCase createAddressUseCase, GetRoleByRoleType getRoleByRoleType) {
        this.professionalGateway = professionalGateway;
        this.createAddressUseCase = createAddressUseCase;
        this.getRoleByRoleType = getRoleByRoleType;
    }

    @Override
    public Professional execute(Professional professional) {
        var roleType = getRoleByRoleType.execute(RoleType.ROLE_PROFESSIONAL);
        var address =  createAddressUseCase.execute(professional.getAddress());
        professional.setAddress(address);
        professional.getAccessData().getRoles().add(roleType);
        return professionalGateway.save(professional);
    }
}
