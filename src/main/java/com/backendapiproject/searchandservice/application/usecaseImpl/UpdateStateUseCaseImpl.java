package com.backendapiproject.searchandservice.application.usecaseImpl;

import com.backendapiproject.searchandservice.application.gateway.StateGateway;
import com.backendapiproject.searchandservice.application.util.ObjectMapperUtil;
import com.backendapiproject.searchandservice.core.domain.State;
import com.backendapiproject.searchandservice.usecase.GetStateByIdUseCase;
import com.backendapiproject.searchandservice.usecase.UpdateCountryUseCase;
import com.backendapiproject.searchandservice.usecase.UpdateStateUseCase;

public class UpdateStateUseCaseImpl implements UpdateStateUseCase {

    private final StateGateway stateGateway;
    private final GetStateByIdUseCase  getStateById;
    private final UpdateCountryUseCase updateCountryUseCase;

    public UpdateStateUseCaseImpl(StateGateway stateGateway, GetStateByIdUseCase getStateById, UpdateCountryUseCase updateCountryUseCase) {
        this.stateGateway = stateGateway;
        this.getStateById = getStateById;
        this.updateCountryUseCase = updateCountryUseCase;
    }


    @Override
    public State execute(State state) {
        var currentState = getStateById.execute(state.getId());
        var country = updateCountryUseCase.execute(state.getCountry());
        ObjectMapperUtil.mapProperties(state, currentState);
        currentState.setCountry(country);
        return stateGateway.update(currentState);
    }
}
