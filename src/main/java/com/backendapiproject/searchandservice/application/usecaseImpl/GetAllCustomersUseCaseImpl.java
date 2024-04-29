package com.backendapiproject.searchandservice.application.usecaseImpl;

import com.backendapiproject.searchandservice.application.gateway.CustomerGateway;
import com.backendapiproject.searchandservice.core.domain.Customer;
import com.backendapiproject.searchandservice.usecase.GetAllCustomersUseCase;

import java.util.List;

public class GetAllCustomersUseCaseImpl implements GetAllCustomersUseCase {

    private final CustomerGateway customerGateway;

    public GetAllCustomersUseCaseImpl(CustomerGateway customerGateway) {
        this.customerGateway = customerGateway;
    }

    @Override
    public List<Customer> execute() {
        return customerGateway.findAll();
    }
}
