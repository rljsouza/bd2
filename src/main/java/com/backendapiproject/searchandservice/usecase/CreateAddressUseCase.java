package com.backendapiproject.searchandservice.usecase;

import com.backendapiproject.searchandservice.core.domain.Address;

public interface CreateAddressUseCase {
    Address execute(Address address);
}
