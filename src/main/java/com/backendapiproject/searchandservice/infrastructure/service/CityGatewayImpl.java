package com.backendapiproject.searchandservice.infrastructure.service;

import com.backendapiproject.searchandservice.application.gateway.CityGateway;
import com.backendapiproject.searchandservice.core.domain.City;
import com.backendapiproject.searchandservice.infrastructure.mapper.CityMapper;
import com.backendapiproject.searchandservice.infrastructure.repository.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class CityGatewayImpl implements CityGateway {

    private final CityRepository repository;
    private final CityMapper mapper;

    @Transactional
    @Override
    public City save(City city) {
        var cityEntity =  repository.save(mapper.toCityEntity(city));
        return mapper.toCity(cityEntity);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Transactional
    @Override
    public City update(City city) {
        var cityEntity =  repository.save(mapper.toCityEntity(city));
        return mapper.toCity(cityEntity);
    }

    @Override
    public Optional<City> findById(Long id) {
        var cityEntity = repository.findById(id);
        return cityEntity.map(mapper::toCity);
    }

    @Override
    public List<City> findAll() {
        var cityEntities = repository.findAll();
        return mapper.toCity(cityEntities);
    }
}
