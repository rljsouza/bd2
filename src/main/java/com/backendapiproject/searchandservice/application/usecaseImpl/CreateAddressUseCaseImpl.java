package com.backendapiproject.searchandservice.application.usecaseImpl;

import com.backendapiproject.searchandservice.application.gateway.AddressGateway;
import com.backendapiproject.searchandservice.core.domain.Address;
import com.backendapiproject.searchandservice.usecase.CreateAddressUseCase;
import com.backendapiproject.searchandservice.usecase.CreateCityUseCase;
import com.backendapiproject.searchandservice.usecase.GetCityByIdUseCase;

public class CreateAddressUseCaseImpl implements CreateAddressUseCase{

    private final AddressGateway addressGateway;
    private final GetCityByIdUseCase getCityByIdUseCase;

    public CreateAddressUseCaseImpl(AddressGateway addressGateway, GetCityByIdUseCase getCityByIdUseCase) {
        this.addressGateway = addressGateway;
        this.getCityByIdUseCase = getCityByIdUseCase;
    }

    @Override
    public Address execute(Address address) {
        var city = getCityByIdUseCase.execute(address.getCity().getId());
        address.setCity(city);
        return addressGateway.save(address);
    }

}
