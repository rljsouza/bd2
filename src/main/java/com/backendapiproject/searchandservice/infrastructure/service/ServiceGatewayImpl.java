package com.backendapiproject.searchandservice.infrastructure.service;

import com.backendapiproject.searchandservice.application.gateway.ServiceGateway;
import com.backendapiproject.searchandservice.core.domain.Service;
import com.backendapiproject.searchandservice.infrastructure.mapper.ServiceMapper;
import com.backendapiproject.searchandservice.infrastructure.repository.ServiceRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;


@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class ServiceGatewayImpl implements ServiceGateway {

    private final ServiceRepository repository;
    private final ServiceMapper mapper;

    @Override
    public Service save(Service service) {
        var serviceEntity =  repository.save(mapper.toServiceEntity(service));
        return mapper.toService(serviceEntity);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Service update(Service service) {
        var serviceEntity =  repository.save(mapper.toServiceEntity(service));
        return mapper.toService(serviceEntity);
    }

    @Override
    public Optional<Service> findById(Long id) {
        var serviceEntity = repository.findById(id);
        return serviceEntity.map(mapper::toService);
    }

    @Override
    public List<Service> findAll() {
        return mapper.toService(repository.findAll());
    }
}
