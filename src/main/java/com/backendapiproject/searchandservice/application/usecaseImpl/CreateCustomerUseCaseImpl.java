package com.backendapiproject.searchandservice.application.usecaseImpl;

import com.backendapiproject.searchandservice.application.gateway.CustomerGateway;
import com.backendapiproject.searchandservice.core.domain.Customer;
import com.backendapiproject.searchandservice.infrastructure.dto.enums.RoleType;
import com.backendapiproject.searchandservice.usecase.CreateAddressUseCase;
import com.backendapiproject.searchandservice.usecase.CreateCustomerUseCase;
import com.backendapiproject.searchandservice.usecase.GetRoleByRoleType;

public class CreateCustomerUseCaseImpl implements CreateCustomerUseCase {

    private final CustomerGateway customerGateway;
    private final CreateAddressUseCase createAddressUseCase;
    private final GetRoleByRoleType getRoleByRoleType;

    public CreateCustomerUseCaseImpl(CustomerGateway customerGateway, CreateAddressUseCase createAddressUseCase, GetRoleByRoleType getRoleByRoleType) {
        this.customerGateway = customerGateway;
        this.createAddressUseCase = createAddressUseCase;
        this.getRoleByRoleType = getRoleByRoleType;
    }


    @Override
    public Customer execute(Customer customer) {
        var roleType = getRoleByRoleType.execute(RoleType.ROLE_USER);
        var address = createAddressUseCase.execute(customer.getAddress());
        customer.setAddress(address);
        customer.getAccessData().getRoles().add(roleType);
        return customerGateway.save(customer);
    }
}
