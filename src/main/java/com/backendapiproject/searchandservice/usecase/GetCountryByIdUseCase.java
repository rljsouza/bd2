package com.backendapiproject.searchandservice.usecase;

import com.backendapiproject.searchandservice.core.domain.Country;

public interface GetCountryByIdUseCase {
    Country execute(Long id);
}
