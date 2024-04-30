package com.backendapiproject.searchandservice.infrastructure.service;

import com.backendapiproject.searchandservice.application.gateway.ProfessionalGateway;
import com.backendapiproject.searchandservice.core.domain.Professional;

import java.util.List;
import java.util.Optional;


public class ProfessionalGatewayImpl implements ProfessionalGateway {

    @Override
    public Professional save(Professional country) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Professional update(Professional country) {
        return null;
    }

    @Override
    public Optional<Professional> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Professional> findAll() {
        return List.of();
    }
}
