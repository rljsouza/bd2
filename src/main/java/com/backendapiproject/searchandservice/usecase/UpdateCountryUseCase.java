package com.backendapiproject.searchandservice.usecase;

import com.backendapiproject.searchandservice.core.domain.Country;

public interface UpdateCountryUseCase {
    Country execute(Country country, Long id);
}
