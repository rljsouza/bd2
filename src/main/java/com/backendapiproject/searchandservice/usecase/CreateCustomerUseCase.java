package com.backendapiproject.searchandservice.usecase;

import com.backendapiproject.searchandservice.core.domain.Customer;

public interface CreateCustomerUseCase {
    Customer execute(Customer customer);
}
