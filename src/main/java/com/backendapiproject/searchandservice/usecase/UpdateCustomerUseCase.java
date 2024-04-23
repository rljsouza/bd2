package com.backendapiproject.searchandservice.usecase;

import com.backendapiproject.searchandservice.core.domain.Customer;

public interface UpdateClientUseCase {
    void execute(Customer client);
}
