package com.backendapiproject.searchandservice.usecase;

import com.backendapiproject.searchandservice.core.domain.City;
import lombok.extern.java.Log;

public interface UpdateCityUseCase {
    City execute(City city, Long id);
}
