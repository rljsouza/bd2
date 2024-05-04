package com.backendapiproject.searchandservice.infrastructure.controller;

import com.backendapiproject.searchandservice.core.domain.Customer;
import com.backendapiproject.searchandservice.infrastructure.dto.request.CustomerRequest;
import com.backendapiproject.searchandservice.infrastructure.mapper.CustomerMapper;
import com.backendapiproject.searchandservice.usecase.CreateCustomerUseCase;
import com.backendapiproject.searchandservice.usecase.DeleteCustomerByIdUseCase;
import com.backendapiproject.searchandservice.usecase.GetCustomerByIdUseCase;
import com.backendapiproject.searchandservice.usecase.ListCustomersUseCase;
import com.backendapiproject.searchandservice.usecase.UpdateCustomerUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/api/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CreateCustomerUseCase createCustomerUseCase;
    private final GetCustomerByIdUseCase getCustomerByIdUseCase;
    private final UpdateCustomerUseCase updateCustomerUseCase;
    private final DeleteCustomerByIdUseCase deleteCustomerByIdUseCase;
    private final ListCustomersUseCase listCustomersUseCase;
    private final CustomerMapper mapper;


    @PostMapping
    public ResponseEntity<Customer> saveCustomer(@RequestBody CustomerRequest request) {
        var savedCustomer = createCustomerUseCase.execute(mapper.toCustomer(request));
        return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
        var customer =  getCustomerByIdUseCase.execute(id);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody CustomerRequest request) {
        var updatedCustomer = updateCustomerUseCase.execute(mapper.toCustomer(request), id);
        return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomerById(@PathVariable Long id) {
        deleteCustomerByIdUseCase.execute(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers() {
        var customers = listCustomersUseCase.execute();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }
}
