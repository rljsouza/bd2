package com.backendapiproject.searchandservice.usecase;

import com.backendapiproject.searchandservice.core.domain.Service;

public interface UpdateServiceUseCase {
    Service execute(Service service, Long id);
}
