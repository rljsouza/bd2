package com.backendapiproject.searchandservice.infrastructure.service;

import com.backendapiproject.searchandservice.application.gateway.AddressGateway;
import com.backendapiproject.searchandservice.core.domain.Address;

import java.util.Optional;


public class AddressGatewayImpl implements AddressGateway {

    @Override
    public Address save(Address address) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Address update(Address address) {
        return null;
    }

    @Override
    public Optional<Address> findById(Long id) {
        return Optional.empty();
    }
}
