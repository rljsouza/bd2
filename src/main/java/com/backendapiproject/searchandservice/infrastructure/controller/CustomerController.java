package com.backendapiproject.searchandservice.infrastructure.controller;

import com.backendapiproject.searchandservice.core.domain.Customer;
import com.backendapiproject.searchandservice.infrastructure.annotation.Authorize;
import com.backendapiproject.searchandservice.infrastructure.dto.request.CustomerRequest;
import com.backendapiproject.searchandservice.infrastructure.dto.response.CustomerResponse;
import com.backendapiproject.searchandservice.infrastructure.mapper.CustomerMapper;
import com.backendapiproject.searchandservice.infrastructure.repository.CustomerReviewRepository;
import com.backendapiproject.searchandservice.usecase.CreateCustomerUseCase;
import com.backendapiproject.searchandservice.usecase.DeleteCustomerByIdUseCase;
import com.backendapiproject.searchandservice.usecase.GetCustomerByIdUseCase;
import com.backendapiproject.searchandservice.usecase.ListCustomersUseCase;
import com.backendapiproject.searchandservice.usecase.UpdateCustomerUseCase;
import jakarta.validation.Valid;
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
    private final CustomerReviewRepository customerReviewRepository;



    @PostMapping
    public ResponseEntity<Customer> saveCustomer(@RequestBody @Valid CustomerRequest request) {
        var savedCustomer = createCustomerUseCase.execute(mapper.toCustomer(request));
        return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> getCustomerById(@PathVariable Long id) {
        var customer =  getCustomerByIdUseCase.execute(id);
        return new ResponseEntity<>(mapper.toCustomerResponse(customer), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @Authorize(value = "ROLE_USER")
    public ResponseEntity<CustomerResponse> updateCustomer(@PathVariable Long id, @Valid @RequestBody CustomerRequest request) {
        var updatedCustomer = updateCustomerUseCase.execute(mapper.toCustomer(request), id);
        return new ResponseEntity<>(mapper.toCustomerResponse(updatedCustomer), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    //@Authorize(value = "ROLE_USER")
    public ResponseEntity<Void> deleteCustomerById(@PathVariable Long id) {
        deleteCustomerByIdUseCase.execute(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping("/trigger/{id}")
    //@Authorize(value = "ROLE_USER")
    public ResponseEntity<Void> deleteCustomerTriggerrById(@PathVariable Long id) {
        customerReviewRepository.deleteCustomerById(id.intValue());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @GetMapping
    public ResponseEntity<List<CustomerResponse>> getAllCustomers() {
        var customers = listCustomersUseCase.execute();
        return new ResponseEntity<>(mapper.toCustomerResponse(customers), HttpStatus.OK);
    }
}
