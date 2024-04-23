package com.backendapiproject.searchandservice.usecase;

import com.backendapiproject.searchandservice.core.domain.Customer;

public interface GetClientByIdUseCase {
    Customer execute(Long id);


}
