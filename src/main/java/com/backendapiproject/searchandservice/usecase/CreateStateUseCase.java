package com.backendapiproject.searchandservice.usecase;

import com.backendapiproject.searchandservice.core.domain.State;

public interface CreateStateUseCase {
    State execute(State state);
}
