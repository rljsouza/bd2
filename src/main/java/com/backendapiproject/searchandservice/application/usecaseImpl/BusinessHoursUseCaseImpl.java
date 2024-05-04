package com.backendapiproject.searchandservice.application.usecaseImpl;

import com.backendapiproject.searchandservice.application.gateway.BusinessHoursUseCaseGateway;
import com.backendapiproject.searchandservice.core.domain.BusinessHours;
import com.backendapiproject.searchandservice.usecase.BusinessHoursUseCase;

import java.util.List;

public class BusinessHoursUseCaseImpl implements BusinessHoursUseCase {

    private final BusinessHoursUseCaseGateway caseGateway;

    public BusinessHoursUseCaseImpl(BusinessHoursUseCaseGateway caseGateway) {
        this.caseGateway = caseGateway;
    }

    @Override
    public List<BusinessHours> create(List<BusinessHours> businessHours) {
        return caseGateway.create(businessHours);
    }

    @Override
    public void deleteById(Long id) {
        caseGateway.deleteById(id);
    }

    @Override
    public BusinessHours getBusinessHoursById(Long id) {
        return caseGateway.getBusinessHoursById(id);
    }

    @Override
    public List<BusinessHours> listBusinessHours() {
        return caseGateway.listBusinessHours();
    }
}
