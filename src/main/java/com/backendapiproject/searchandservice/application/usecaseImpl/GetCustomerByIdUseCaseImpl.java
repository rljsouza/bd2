package com.backendapiproject.searchandservice.application.usecaseImpl;

import com.backendapiproject.searchandservice.application.gateway.CustomerGateway;
import com.backendapiproject.searchandservice.core.domain.Customer;
import com.backendapiproject.searchandservice.core.exception.NotFoundException;
import com.backendapiproject.searchandservice.usecase.GetCustomerByIdUseCase;

public class  GetCustomerByIdUseCaseImpl implements GetCustomerByIdUseCase {

    private final CustomerGateway customerGateway;

    public GetCustomerByIdUseCaseImpl(CustomerGateway customerGateway) {
        this.customerGateway = customerGateway;
    }

    @Override
    public Customer execute(Long id) {
        return customerGateway.findById(id)
                .orElseThrow(() -> new NotFoundException("Cliente não encontrado para o ID: " + id));
    }
}
