package com.backendapiproject.searchandservice.usecase;

import com.backendapiproject.searchandservice.core.domain.Address;

public interface GetAddressByIdUseCase {
    Address execute(Long id);
}
