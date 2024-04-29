package com.backendapiproject.searchandservice.usecase;

import com.backendapiproject.searchandservice.core.domain.State;

public interface UpdateStateUseCase {
    State execute(State state);
}
