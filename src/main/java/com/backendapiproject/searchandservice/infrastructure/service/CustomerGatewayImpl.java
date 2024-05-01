package com.backendapiproject.searchandservice.infrastructure.service;

import com.backendapiproject.searchandservice.application.gateway.CustomerGateway;
import com.backendapiproject.searchandservice.core.domain.Customer;
import com.backendapiproject.searchandservice.infrastructure.mapper.CustomerMapper;
import com.backendapiproject.searchandservice.infrastructure.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerGatewayImpl implements CustomerGateway {

    private final CustomerRepository repository;
    private final CustomerMapper mapper;

    @Override
    public Customer save(Customer customer) {
        var customerEntity =  repository.save(mapper.toCustomerEntity(customer));
        return mapper.toCustomer(customerEntity);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Customer update(Customer customer) {
        var customerEntity =  repository.save(mapper.toCustomerEntity(customer));
        return mapper.toCustomer(customerEntity);
    }

    @Override
    public Optional<Customer> findById(Long id) {
        var customerEntity = repository.findById(id);
        return customerEntity.map(mapper::toCustomer);
    }

    @Override
    public List<Customer> findAll() {
        return mapper.toCustomer(repository.findAll());
    }
}
