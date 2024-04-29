package com.backendapiproject.searchandservice.usecase;

import com.backendapiproject.searchandservice.core.domain.Country;

public interface CreateCountryUseCase {
    Country execute(Country country);
}
