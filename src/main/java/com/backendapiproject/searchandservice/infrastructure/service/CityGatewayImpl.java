package com.backendapiproject.searchandservice.infrastructure.service;

import com.backendapiproject.searchandservice.application.gateway.CityGateway;
import com.backendapiproject.searchandservice.core.domain.City;

import java.util.Optional;


public class CityGatewayImpl implements CityGateway {

    @Override
    public City save(City city) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public City update(City city) {
        return null;
    }

    @Override
    public Optional<City> findById(Long id) {
        return Optional.empty();
    }
}
