package com.backendapiproject.searchandservice.usecase;

import com.backendapiproject.searchandservice.core.domain.Service;

public interface ListServiceUseCase {
    Service execute(Long id);
}
