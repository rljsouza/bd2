package com.backendapiproject.searchandservice.infrastructure.service;

import com.backendapiproject.searchandservice.application.gateway.ServiceGateway;
import com.backendapiproject.searchandservice.core.domain.Service;

import java.util.List;
import java.util.Optional;


public class ServiceGatewayImpl implements ServiceGateway {

    @Override
    public Service save(Service service) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Service update(Service service) {
        return null;
    }

    @Override
    public Optional<Service> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Service> findAll() {
        return List.of();
    }
}
