package com.backendapiproject.searchandservice.usecase;

import com.backendapiproject.searchandservice.core.domain.State;

public interface GetStateByIdUseCase {
    State execute(Long id);
}
