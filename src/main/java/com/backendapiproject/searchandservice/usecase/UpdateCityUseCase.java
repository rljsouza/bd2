package com.backendapiproject.searchandservice.usecase;

import com.backendapiproject.searchandservice.core.domain.City;

public interface UpdateCityUseCase {
    City execute(City city);
}
