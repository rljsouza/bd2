package com.backendapiproject.searchandservice.infrastructure.service;

import com.backendapiproject.searchandservice.application.gateway.CountryGateway;
import com.backendapiproject.searchandservice.core.domain.Country;

import java.util.Optional;


public class CountryGatewayImpl implements CountryGateway {


    @Override
    public Country save(Country country) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Country update(Country country) {
        return null;
    }

    @Override
    public Optional<Country> findById(Long id) {
        return Optional.empty();
    }
}
