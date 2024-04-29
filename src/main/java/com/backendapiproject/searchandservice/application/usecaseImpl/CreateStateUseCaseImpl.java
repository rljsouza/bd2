package com.backendapiproject.searchandservice.application.usecaseImpl;

import com.backendapiproject.searchandservice.application.gateway.StateGateway;
import com.backendapiproject.searchandservice.core.domain.State;
import com.backendapiproject.searchandservice.usecase.CreateCountryUseCase;
import com.backendapiproject.searchandservice.usecase.CreateStateUseCase;

public class CreateStateUseCaseImpl implements CreateStateUseCase {

    private final StateGateway stateGateway;
    private final CreateCountryUseCase createCountryUseCase;

    public CreateStateUseCaseImpl(StateGateway stateGateway, CreateCountryUseCase createCountryUseCase) {
        this.stateGateway = stateGateway;
        this.createCountryUseCase = createCountryUseCase;
    }

    @Override
    public State execute(State state) {
        var country = createCountryUseCase.execute(state.getCountry());
        state.setCountry(country);
        return stateGateway.save(state);
    }
}
