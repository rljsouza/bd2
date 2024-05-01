package com.backendapiproject.searchandservice.application.usecaseImpl;

import com.backendapiproject.searchandservice.application.gateway.AddressGateway;
import com.backendapiproject.searchandservice.usecase.DeleteAddressByIdUseCase;
import com.backendapiproject.searchandservice.usecase.GetAddressByIdUseCase;

public class DeleteAddressByIdUseCaseImpl implements DeleteAddressByIdUseCase {

    private final AddressGateway addressGateway;
    private final GetAddressByIdUseCase getAddressById;

    public DeleteAddressByIdUseCaseImpl(AddressGateway addressGateway, GetAddressByIdUseCase getAddressById) {
        this.addressGateway = addressGateway;
        this.getAddressById = getAddressById;
    }

    @Override
    public void execute(Long id) {
        getAddressById.execute(id);
        addressGateway.deleteById(id);
    }

}
