package com.backendapiproject.searchandservice.usecase;

import com.backendapiproject.searchandservice.core.domain.Service;

public interface GetServiceByIdUseCase {
    Service execute(Long id);
}
