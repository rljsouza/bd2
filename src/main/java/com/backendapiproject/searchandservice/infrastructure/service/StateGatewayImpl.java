package com.backendapiproject.searchandservice.infrastructure.service;

import com.backendapiproject.searchandservice.application.gateway.StateGateway;
import com.backendapiproject.searchandservice.core.domain.State;
import com.backendapiproject.searchandservice.infrastructure.mapper.StateMapper;
import com.backendapiproject.searchandservice.infrastructure.repository.StateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class StateGatewayImpl implements StateGateway {

    private final StateRepository repository;
    private final StateMapper mapper;

    @Transactional
    @Override
    public State save(State state) {
        var stateEntity =  repository.save(mapper.toStateEntity(state));
        return mapper.toSate(stateEntity);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Transactional
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

    @Override
    public List<State> findAll() {
        var stateEntity = repository.findAll();
        return mapper.toSate(stateEntity);
    }
}
