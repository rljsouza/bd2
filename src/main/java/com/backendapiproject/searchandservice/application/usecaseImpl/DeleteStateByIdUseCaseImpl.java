package com.backendapiproject.searchandservice.application.usecaseImpl;

import com.backendapiproject.searchandservice.application.gateway.StateGateway;
import com.backendapiproject.searchandservice.usecase.DeleteStateByIdUseCase;
import com.backendapiproject.searchandservice.usecase.GetStateByIdUseCase;

public class DeleteStateByIdUseCaseImpl implements DeleteStateByIdUseCase {

    private final StateGateway stateGateway;
    private final GetStateByIdUseCase getStateById;

    public DeleteStateByIdUseCaseImpl(StateGateway stateGateway, GetStateByIdUseCase getStateById) {
        this.stateGateway = stateGateway;
        this.getStateById = getStateById;
    }

    @Override
    public void execute(Long id) {
        getStateById.execute(id);
        stateGateway.delete(id);
    }
}
