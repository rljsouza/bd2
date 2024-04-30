package com.backendapiproject.searchandservice.usecase;

import com.backendapiproject.searchandservice.core.domain.Professional;
import com.backendapiproject.searchandservice.core.domain.Service;

public interface AddServiceUseCase {
    Professional execute(Service service, Long professionalId);
}
