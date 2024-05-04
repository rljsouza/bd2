package com.backendapiproject.searchandservice.infrastructure.config.main;

import com.backendapiproject.searchandservice.application.gateway.CustomerGateway;
import com.backendapiproject.searchandservice.application.usecaseImpl.CreateCustomerUseCaseImpl;
import com.backendapiproject.searchandservice.application.usecaseImpl.DeleteCustomerByIdUseCaseImpl;
import com.backendapiproject.searchandservice.application.usecaseImpl.GetCustomerByIdUseCaseImpl;
import com.backendapiproject.searchandservice.application.usecaseImpl.ListCustomersUseCaseImpl;
import com.backendapiproject.searchandservice.application.usecaseImpl.UpdateCustomerUseCaseImpl;
import com.backendapiproject.searchandservice.usecase.CreateAddressUseCase;
import com.backendapiproject.searchandservice.usecase.CreateCustomerUseCase;
import com.backendapiproject.searchandservice.usecase.DeleteCustomerByIdUseCase;
import com.backendapiproject.searchandservice.usecase.GetCustomerByIdUseCase;
import com.backendapiproject.searchandservice.usecase.GetRoleByRoleType;
import com.backendapiproject.searchandservice.usecase.ListCustomersUseCase;
import com.backendapiproject.searchandservice.usecase.UpdateAddressUseCase;
import com.backendapiproject.searchandservice.usecase.UpdateCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerMain {

    @Bean
    public CreateCustomerUseCase createCustomerUseCase(CustomerGateway customerGateway, CreateAddressUseCase createAddressUseCase, GetRoleByRoleType getRoleByRoleType){
        return new CreateCustomerUseCaseImpl(customerGateway, createAddressUseCase, getRoleByRoleType);
    }
    @Bean
    public GetCustomerByIdUseCase getCustomerByIdUseCase(CustomerGateway customerGateway){
        return new GetCustomerByIdUseCaseImpl(customerGateway);
    }
    @Bean
    public UpdateCustomerUseCase updateCustomerUseCase(CustomerGateway customerGateway, GetCustomerByIdUseCase getCustomerById, UpdateAddressUseCase updateAddressUseCase){
        return new UpdateCustomerUseCaseImpl(customerGateway, getCustomerById, updateAddressUseCase);
    }
    @Bean
    public DeleteCustomerByIdUseCase deleteCustomerByIdUseCase(CustomerGateway customerGateway, GetCustomerByIdUseCase getCustomerById){
        return new DeleteCustomerByIdUseCaseImpl(customerGateway, getCustomerById);
    };
    @Bean
    public  ListCustomersUseCase listCustomersUseCase(CustomerGateway customerGateway){
        return new ListCustomersUseCaseImpl(customerGateway);
    };
}
