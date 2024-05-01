package com.backendapiproject.searchandservice.application.gateway;

import com.backendapiproject.searchandservice.core.domain.Address;

import java.util.Optional;


public interface AddressGateway {

    Address save(Address address);
    void deleteById(Long id);
    Address update(Address address);
    Optional<Address> findById(Long id);
}
