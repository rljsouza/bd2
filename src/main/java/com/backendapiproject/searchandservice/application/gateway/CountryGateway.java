package com.backendapiproject.searchandservice.application.gateway;

import com.backendapiproject.searchandservice.core.domain.Country;

import java.util.Optional;


public interface CountryGateway {

    Country save(Country country);
    void delete(Long id);
    Country update(Country country);
    Optional<Country> findById(Long id);
}
