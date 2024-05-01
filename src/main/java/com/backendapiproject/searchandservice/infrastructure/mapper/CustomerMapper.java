package com.backendapiproject.searchandservice.infrastructure.mapper;

import com.backendapiproject.searchandservice.core.domain.Customer;
import com.backendapiproject.searchandservice.infrastructure.entity.CustomerEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class CustomerMapper {

    private final ModelMapper mapper;

    public CustomerEntity toCustomerEntity(Customer customer){
        return mapper.map(customer, CustomerEntity.class);
    }

    public Customer toCustomer(CustomerEntity customer){
        return mapper.map(customer,  Customer.class);
    }

    public List<Customer> toCustomer(List<CustomerEntity> customers) {
        return customers.stream()
                .map(this::toCustomer)
                .collect(Collectors.toList());
    }
}
