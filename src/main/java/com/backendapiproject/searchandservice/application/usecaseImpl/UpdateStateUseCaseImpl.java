package com.backendapiproject.searchandservice.application.usecaseImpl;

import com.backendapiproject.searchandservice.application.gateway.StateGateway;
import com.backendapiproject.searchandservice.application.util.ObjectMapperUtil;
import com.backendapiproject.searchandservice.core.domain.State;
import com.backendapiproject.searchandservice.usecase.GetCountryByIdUseCase;
import com.backendapiproject.searchandservice.usecase.GetStateByIdUseCase;
import com.backendapiproject.searchandservice.usecase.UpdateStateUseCase;

public class UpdateStateUseCaseImpl implements UpdateStateUseCase {

    private final StateGateway stateGateway;
    private final GetStateByIdUseCase  getStateById;
    private final GetCountryByIdUseCase getCountryByIdUseCase;

    public UpdateStateUseCaseImpl(StateGateway stateGateway, GetStateByIdUseCase getStateById, GetCountryByIdUseCase getCountryByIdUseCase) {
        this.stateGateway = stateGateway;
        this.getStateById = getStateById;
        this.getCountryByIdUseCase = getCountryByIdUseCase;
    }


    @Override
    public State execute(State state, Long id) {
        var currentState = getStateById.execute(id);
        var country = getCountryByIdUseCase.execute(state.getCountry().getId());
        ObjectMapperUtil.mapProperties(state, currentState);
        currentState.setCountry(country);
        return stateGateway.update(currentState);
    }
}
