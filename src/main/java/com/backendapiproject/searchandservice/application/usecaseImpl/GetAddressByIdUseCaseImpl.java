package com.backendapiproject.searchandservice.application.usecaseImpl;

import com.backendapiproject.searchandservice.application.gateway.AddressGateway;
import com.backendapiproject.searchandservice.core.domain.Address;
import com.backendapiproject.searchandservice.core.exception.NotFoundException;
import com.backendapiproject.searchandservice.usecase.GetAddressByIdUseCase;

public class GetAddressByIdUseCaseImpl implements GetAddressByIdUseCase {

    private final AddressGateway addressGateway;

    public GetAddressByIdUseCaseImpl(AddressGateway addressGateway) {
        this.addressGateway = addressGateway;
    }

    @Override
    public Address execute(Long id) {
        return addressGateway.findById(id)
                .orElseThrow(() -> new NotFoundException("Endereço não encontrado para o ID: " + id));
    }

}
