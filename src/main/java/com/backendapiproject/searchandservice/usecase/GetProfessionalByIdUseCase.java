package com.backendapiproject.searchandservice.usecase;

import com.backendapiproject.searchandservice.core.domain.Professional;

public interface GetProfessionalByIdUseCase {
    Professional execute(Long id);
}
