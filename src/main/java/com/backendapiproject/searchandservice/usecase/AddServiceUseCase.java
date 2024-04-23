package com.backendapiproject.searchandservice.usecase;

import com.backendapiproject.searchandservice.core.domain.Service;

interface AddServiceUseCase {
    void execute(Service service);
}
