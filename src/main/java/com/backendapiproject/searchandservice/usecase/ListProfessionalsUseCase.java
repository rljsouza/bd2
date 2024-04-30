package com.backendapiproject.searchandservice.usecase;

import com.backendapiproject.searchandservice.core.domain.Professional;

import java.util.List;

public interface ListProfessionalsUseCase {
    List<Professional> execute();
}
