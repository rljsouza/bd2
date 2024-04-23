package com.backendapiproject.searchandservice.usecase;

import com.backendapiproject.searchandservice.core.domain.Customer;

public interface GetCustomerByIdUseCase {
    Customer execute(Long id);
}
