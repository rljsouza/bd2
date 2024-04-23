package com.backendapiproject.searchandservice.usecase;

import com.backendapiproject.searchandservice.core.domain.Service;

public interface AddServiceUseCase {
    void execute(Service service);
}
