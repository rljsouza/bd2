package com.backendapiproject.searchandservice.usecase;

import com.backendapiproject.searchandservice.core.domain.City;

public interface CreateCityUseCase {
    City execute(City city);
}
