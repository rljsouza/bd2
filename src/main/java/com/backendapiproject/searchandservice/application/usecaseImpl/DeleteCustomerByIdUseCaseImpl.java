package com.backendapiproject.searchandservice.application.usecaseImpl;

import com.backendapiproject.searchandservice.application.gateway.CustomerGateway;
import com.backendapiproject.searchandservice.usecase.DeleteCustomerByIdUseCase;
import com.backendapiproject.searchandservice.usecase.GetCustomerByIdUseCase;

public class DeleteCustomerByIdUseCaseImpl implements DeleteCustomerByIdUseCase {

    private final CustomerGateway customerGateway;
    private final GetCustomerByIdUseCase getCustomerById;

    public DeleteCustomerByIdUseCaseImpl(CustomerGateway customerGateway, GetCustomerByIdUseCase getCustomerById) {
        this.customerGateway = customerGateway;
        this.getCustomerById = getCustomerById;
    }

    @Override
    public void execute(Long id) {
        getCustomerById.execute(id);
        customerGateway.delete(id);
    }
}
