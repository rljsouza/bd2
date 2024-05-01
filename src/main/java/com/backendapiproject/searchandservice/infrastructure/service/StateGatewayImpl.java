package com.backendapiproject.searchandservice.infrastructure.service;

import com.backendapiproject.searchandservice.application.gateway.StateGateway;
import com.backendapiproject.searchandservice.core.domain.State;
import com.backendapiproject.searchandservice.infrastructure.mapper.StateMapper;
import com.backendapiproject.searchandservice.infrastructure.repository.StateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class StateGatewayImpl implements StateGateway {

    private final StateRepository repository;
    private final StateMapper mapper;

    @Override
    public State save(State state) {
        var stateEntity =  repository.save(mapper.toStateEntity(state));
        return mapper.toSate(stateEntity);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public State update(State state) {
        var stateEntity =  repository.save(mapper.toStateEntity(state));
        return mapper.toSate(stateEntity);
    }

    @Override
    public Optional<State> findById(Long id) {
        var stateEntity = repository.findById(id);
        return stateEntity.map(mapper::toSate);
    }
}
