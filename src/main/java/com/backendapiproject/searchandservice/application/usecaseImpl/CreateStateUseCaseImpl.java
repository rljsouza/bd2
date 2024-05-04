package com.backendapiproject.searchandservice.application.usecaseImpl;

import com.backendapiproject.searchandservice.application.gateway.StateGateway;
import com.backendapiproject.searchandservice.core.domain.State;
import com.backendapiproject.searchandservice.usecase.CreateStateUseCase;
import com.backendapiproject.searchandservice.usecase.GetCountryByIdUseCase;

public class CreateStateUseCaseImpl implements CreateStateUseCase {

    private final StateGateway stateGateway;
    private final GetCountryByIdUseCase getCountryByIdUseCase;

    public CreateStateUseCaseImpl(StateGateway stateGateway, GetCountryByIdUseCase getCountryByIdUseCase) {
        this.stateGateway = stateGateway;
        this.getCountryByIdUseCase = getCountryByIdUseCase;
    }

    @Override
    public State execute(State state) {
        var country = getCountryByIdUseCase.execute(state.getCountry().getId());
        state.setCountry(country);
        return stateGateway.save(state);
    }
}
