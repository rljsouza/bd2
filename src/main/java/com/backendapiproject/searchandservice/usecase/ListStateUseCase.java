package com.backendapiproject.searchandservice.usecase;

import com.backendapiproject.searchandservice.core.domain.State;

import java.util.List;

public interface ListStateUseCase {
    List<State> execute();
}
