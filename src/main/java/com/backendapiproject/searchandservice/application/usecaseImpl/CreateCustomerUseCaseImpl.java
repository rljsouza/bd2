package com.backendapiproject.searchandservice.application.usecaseImpl;

import com.backendapiproject.searchandservice.application.gateway.CustomerGateway;
import com.backendapiproject.searchandservice.core.domain.Customer;
import com.backendapiproject.searchandservice.usecase.CreateAddressUseCase;
import com.backendapiproject.searchandservice.usecase.CreateCustomerUseCase;

public class CreateCustomerUseCaseImpl implements CreateCustomerUseCase {

    private final CustomerGateway customerGateway;
    private final CreateAddressUseCase createAddressUseCase;

    public CreateCustomerUseCaseImpl(CustomerGateway customerGateway, CreateAddressUseCase createAddressUseCase) {
        this.customerGateway = customerGateway;
        this.createAddressUseCase = createAddressUseCase;
    }


    @Override
    public Customer execute(Customer customer) {
       var address = createAddressUseCase.execute(customer.getAddress());
        customer.setAddress(address);
        return customerGateway.save(customer);
    }
}
