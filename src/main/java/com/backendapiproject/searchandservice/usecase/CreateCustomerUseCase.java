package com.backendapiproject.searchandservice.usecase;

import com.backendapiproject.searchandservice.core.domain.Customer;

public interface CreateCustomerUseCase {
    void execute(Customer customer);
}
