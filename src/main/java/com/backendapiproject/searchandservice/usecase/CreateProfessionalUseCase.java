package com.backendapiproject.searchandservice.usecase;

import com.backendapiproject.searchandservice.core.domain.Professional;

public interface CreateProfessionalUseCase {
    Professional execute(Professional professional);
}
