package com.backendapiproject.searchandservice.usecase;

import com.backendapiproject.searchandservice.core.domain.Address;

public interface UpdateAddressUseCase {
    Address execute(Address address);
}
