package com.backendapiproject.searchandservice.application.usecaseImpl;

import com.backendapiproject.searchandservice.core.domain.Customer;
import com.backendapiproject.searchandservice.usecase.GetAllCustomersUseCase;

import java.util.List;

public class GetAllCustomersUseCaseImpl implements GetAllCustomersUseCase {

    @Override
    public List<Customer> execute() {
        return List.of();
    }
}
