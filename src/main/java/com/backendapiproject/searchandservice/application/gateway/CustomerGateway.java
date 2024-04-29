package com.backendapiproject.searchandservice.application.gateway;

import com.backendapiproject.searchandservice.core.domain.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerGateway {

    Customer save(Customer customer);
    void delete(Long id);
    Customer update(Customer customer);
    Optional<Customer> findById(Long id);
    List<Customer> findAll();
}
