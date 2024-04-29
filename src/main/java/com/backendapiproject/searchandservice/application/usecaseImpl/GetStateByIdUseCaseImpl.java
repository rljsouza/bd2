package com.backendapiproject.searchandservice.application.usecaseImpl;

import com.backendapiproject.searchandservice.application.gateway.StateGateway;
import com.backendapiproject.searchandservice.core.domain.State;
import com.backendapiproject.searchandservice.core.exception.NotFoundException;
import com.backendapiproject.searchandservice.usecase.GetStateByIdUseCase;

public class GetStateByIdUseCaseImpl implements GetStateByIdUseCase {

    private final StateGateway stateGateway;

    public GetStateByIdUseCaseImpl(StateGateway stateGateway) {
        this.stateGateway = stateGateway;
    }

    @Override
    public State execute(Long id) {
        return stateGateway.findById(id)
                .orElseThrow(() -> new NotFoundException("Estado não encontrado para o ID: " + id));
    }
}
