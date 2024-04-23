package com.backendapiproject.searchandservice.application.usecaseImpl;

import com.backendapiproject.searchandservice.core.domain.Professional;
import com.backendapiproject.searchandservice.usecase.GetAllProfessionalsUseCase;

import java.util.List;

public class GetAllProfessionalsUseCaseImpl implements GetAllProfessionalsUseCase {

    @Override
    public List<Professional> execute() {
        return List.of();
    }
}
