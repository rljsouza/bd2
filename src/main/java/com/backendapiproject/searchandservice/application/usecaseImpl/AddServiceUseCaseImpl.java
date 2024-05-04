package com.backendapiproject.searchandservice.application.usecaseImpl;

import com.backendapiproject.searchandservice.application.gateway.ServiceGateway;
import com.backendapiproject.searchandservice.core.domain.Professional;
import com.backendapiproject.searchandservice.core.domain.Service;
import com.backendapiproject.searchandservice.usecase.AddServiceUseCase;
import com.backendapiproject.searchandservice.usecase.BusinessHoursUseCase;
import com.backendapiproject.searchandservice.usecase.GetProfessionalByIdUseCase;
import com.backendapiproject.searchandservice.usecase.UpdateProfessionalUseCase;

public class AddServiceUseCaseImpl implements AddServiceUseCase {

    private final ServiceGateway serviceGateway;
    private final GetProfessionalByIdUseCase getProfessionalById;
    private final UpdateProfessionalUseCase updateProfessionalUseCase;
    private final BusinessHoursUseCase businessHoursUseCase;

    public AddServiceUseCaseImpl(ServiceGateway serviceGateway, GetProfessionalByIdUseCase getProfessionalById, UpdateProfessionalUseCase updateProfessionalUseCase, BusinessHoursUseCase businessHoursUseCase) {
        this.serviceGateway = serviceGateway;
        this.getProfessionalById = getProfessionalById;
        this.updateProfessionalUseCase = updateProfessionalUseCase;
        this.businessHoursUseCase = businessHoursUseCase;
    }

    @Override
    public Professional execute(Service service, Long professionalId) {
        var professional = getProfessionalById.execute(professionalId);
        var serviceSaved =  serviceGateway.save(service);
        service.getBusinessHours().forEach(bus ->  bus.setService(serviceSaved));
        var businessHours = businessHoursUseCase.create(service.getBusinessHours());
        professional.getServices().add(serviceSaved);
        return updateProfessionalUseCase.execute(professional, professionalId);
    };
}
