package com.backendapiproject.searchandservice.usecase;

import com.backendapiproject.searchandservice.core.domain.Customer;

public interface UpdateCustomerUseCase {
    void execute(Customer client);
}
