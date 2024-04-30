package com.backendapiproject.searchandservice.infrastructure.service;

import com.backendapiproject.searchandservice.application.gateway.CustomerGateway;
import com.backendapiproject.searchandservice.core.domain.Customer;

import java.util.List;
import java.util.Optional;

public class CustomerGatewayImpl implements CustomerGateway {

    @Override
    public Customer save(Customer customer) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Customer update(Customer customer) {
        return null;
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Customer> findAll() {
        return List.of();
    }
}
