package com.backendapiproject.searchandservice.usecase;

import com.backendapiproject.searchandservice.core.domain.Service;

import java.util.List;

public interface GetServiceByProfessionalIdUseCase {
    List<Service> execute(Long professionalId);
}
