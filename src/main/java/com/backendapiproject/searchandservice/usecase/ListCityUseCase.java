package com.backendapiproject.searchandservice.usecase;

import com.backendapiproject.searchandservice.core.domain.City;

import java.util.List;

public interface ListCityUseCase {
    List<City> execute();
}
