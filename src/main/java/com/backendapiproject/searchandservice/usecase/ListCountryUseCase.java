package com.backendapiproject.searchandservice.usecase;

import com.backendapiproject.searchandservice.core.domain.Country;

import java.util.List;

public interface ListCountryUseCase {
    List<Country> execute();
}
