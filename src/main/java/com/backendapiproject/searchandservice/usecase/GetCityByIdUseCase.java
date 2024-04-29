package com.backendapiproject.searchandservice.usecase;

import com.backendapiproject.searchandservice.core.domain.City;

public interface GetCityByIdUseCase {
    City execute(Long id);
}
