package com.backendapiproject.searchandservice.usecase;

import com.backendapiproject.searchandservice.core.domain.Customer;

import java.util.List;

public interface ListCustomersUseCase {
    List<Customer> execute();
}
