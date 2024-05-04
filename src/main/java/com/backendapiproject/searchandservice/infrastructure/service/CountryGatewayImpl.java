package com.backendapiproject.searchandservice.infrastructure.service;

import com.backendapiproject.searchandservice.application.gateway.CountryGateway;
import com.backendapiproject.searchandservice.core.domain.Country;
import com.backendapiproject.searchandservice.infrastructure.mapper.CountryMapper;
import com.backendapiproject.searchandservice.infrastructure.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class CountryGatewayImpl implements CountryGateway {

    private final CountryRepository repository;
    private final CountryMapper mapper;

    @Override
    public Country save(Country country) {
        var countryEntity = repository.save(mapper.toCountryEntity(country));
        return mapper.toCountry(countryEntity);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Country update(Country country) {
        var countryEntity = repository.save(mapper.toCountryEntity(country));
        return mapper.toCountry(countryEntity);
    }

    @Override
    public Optional<Country> findById(Long id) {
        var countryEntity = repository.findById(id);
        return countryEntity.map(mapper::toCountry);
    }

    @Override
    public List<Country> findAll() {
        var countryEntities = repository.findAll();
        return mapper.toCountry(countryEntities);
    }
}
