package com.backendapiproject.searchandservice.infrastructure.service;

import com.backendapiproject.searchandservice.application.gateway.StateGateway;
import com.backendapiproject.searchandservice.core.domain.State;

import java.util.Optional;


public class StateGatewayImpl implements StateGateway {

    @Override
    public State save(State state) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public State update(State state) {
        return null;
    }

    @Override
    public Optional<State> findById(Long id) {
        return Optional.empty();
    }
}
