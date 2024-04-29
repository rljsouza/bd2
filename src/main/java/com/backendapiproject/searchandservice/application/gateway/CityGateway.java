package com.backendapiproject.searchandservice.application.gateway;

import com.backendapiproject.searchandservice.core.domain.City;

import java.util.Optional;


public interface CityGateway {

    City save(City city);
    void delete(Long id);
    City update(City city);
    Optional<City> findById(Long id);
}
