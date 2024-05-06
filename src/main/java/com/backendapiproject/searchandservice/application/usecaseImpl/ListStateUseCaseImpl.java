package com.backendapiproject.searchandservice.application.usecaseImpl;

import com.backendapiproject.searchandservice.application.gateway.StateGateway;
import com.backendapiproject.searchandservice.core.domain.State;
import com.backendapiproject.searchandservice.usecase.ListStateUseCase;

import java.util.List;

public class ListStateUseCaseImpl implements ListStateUseCase {

    private final StateGateway stateGateway;

    public ListStateUseCaseImpl(StateGateway stateGateway) {
        this.stateGateway = stateGateway;
    }

    @Override
    public List<State> execute() {
        return stateGateway.findAll();
    }
}
