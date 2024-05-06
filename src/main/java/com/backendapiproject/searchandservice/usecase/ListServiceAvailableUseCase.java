package com.backendapiproject.searchandservice.usecase;


import com.backendapiproject.searchandservice.core.domain.ServiceAvailability;

import java.util.List;

public interface ListServiceAvailableUseCase {
    List<ServiceAvailability> execute(Long professionalId, Long serviceId);
}
