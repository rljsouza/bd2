package com.backendapiproject.searchandservice.application.gateway;

import com.backendapiproject.searchandservice.core.domain.State;

import java.util.Optional;


public interface StateGateway {

    State save(State state);
    void delete(Long id);
    State update(State state);
    Optional<State> findById(Long id);
}
