package com.backendapiproject.searchandservice.application.gateway;

import com.backendapiproject.searchandservice.core.domain.Country;

import java.util.List;
import java.util.Optional;


public interface CountryGateway {

    Country save(Country country);
    void deleteById(Long id);
    Country update(Country country);
    Optional<Country> findById(Long id);
    List<Country> findAll();
}
