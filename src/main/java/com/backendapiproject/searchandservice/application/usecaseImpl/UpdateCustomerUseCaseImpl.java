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
    public Customer execute(Customer customer, Long id) {
        var currentCustomer  = getCustomerById.execute(id);
        var address = updateAddressUseCase.execute(customer.getAddress(), customer.getAddress().getId());
        ObjectMapperUtil.mapProperties(customer, currentCustomer);
        currentCustomer.setAddress(address);
        return customerGateway.update(currentCustomer);
    }
}
