package com.backendapiproject.searchandservice.application.usecaseImpl;

import com.backendapiproject.searchandservice.application.gateway.AddressGateway;
import com.backendapiproject.searchandservice.core.domain.Address;
import com.backendapiproject.searchandservice.usecase.CreateAddressUseCase;
import com.backendapiproject.searchandservice.usecase.CreateCityUseCase;

public class CreateAddressUseCaseImpl implements CreateAddressUseCase{

    private final AddressGateway addressGateway;
    private final CreateCityUseCase createCityUseCase;

    public CreateAddressUseCaseImpl(AddressGateway addressGateway, CreateCityUseCase createCityUseCase) {
        this.addressGateway = addressGateway;
        this.createCityUseCase = createCityUseCase;
    }

    @Override
    public Address execute(Address address) {
        var city = createCityUseCase.execute(address.getCity());
        address.setCity(city);
        return addressGateway.save(address);
    }

}
