package com.backendapiproject.searchandservice.application.usecaseImpl;

import com.backendapiproject.searchandservice.application.gateway.CustomerGateway;
import com.backendapiproject.searchandservice.application.util.ObjectMapperUtil;
import com.backendapiproject.searchandservice.core.domain.Customer;
import com.backendapiproject.searchandservice.usecase.GetCustomerByIdUseCase;
import com.backendapiproject.searchandservice.usecase.UpdateAddressUseCase;
import com.backendapiproject.searchandservice.usecase.UpdateCustomerUseCase;

public class UpdateCustomerUseCaseImpl implements UpdateCustomerUseCase {

    private final CustomerGateway customerGateway;
    private final GetCustomerByIdUseCase getCustomerById;
    private final UpdateAddressUseCase updateAddressUseCase;

    public UpdateCustomerUseCaseImpl(CustomerGateway customerGateway, GetCustomerByIdUseCase getCustomerById, UpdateAddressUseCase updateAddressUseCase) {
        this.customerGateway = customerGateway;
        this.getCustomerById = getCustomerById;
        this.updateAddressUseCase = updateAddressUseCase;
    }

    @Override
    public Customer execute(Customer customer) {
        var currentCustomer  = getCustomerById.execute(customer.getId());
        var address = updateAddressUseCase.execute(customer.getAddress());
        ObjectMapperUtil.mapProperties(customer, currentCustomer);
        currentCustomer.setAddress(address);
        return customerGateway.update(currentCustomer);
    }
}
