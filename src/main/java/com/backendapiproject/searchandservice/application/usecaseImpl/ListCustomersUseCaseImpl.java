package com.backendapiproject.searchandservice.application.usecaseImpl;

import com.backendapiproject.searchandservice.application.gateway.CustomerGateway;
import com.backendapiproject.searchandservice.core.domain.Customer;
import com.backendapiproject.searchandservice.usecase.ListCustomersUseCase;

import java.util.List;

public class ListCustomersUseCaseImpl implements ListCustomersUseCase {

    private final CustomerGateway customerGateway;

    public ListCustomersUseCaseImpl(CustomerGateway customerGateway) {
        this.customerGateway = customerGateway;
    }

    @Override
    public List<Customer> execute() {
        return customerGateway.findAll();
    }
}
