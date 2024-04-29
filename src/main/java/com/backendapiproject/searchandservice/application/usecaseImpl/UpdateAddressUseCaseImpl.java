package com.backendapiproject.searchandservice.application.usecaseImpl;

import com.backendapiproject.searchandservice.application.gateway.AddressGateway;
import com.backendapiproject.searchandservice.application.util.ObjectMapperUtil;
import com.backendapiproject.searchandservice.core.domain.Address;
import com.backendapiproject.searchandservice.usecase.GetAddressByIdUseCase;
import com.backendapiproject.searchandservice.usecase.UpdateAddressUseCase;
import com.backendapiproject.searchandservice.usecase.UpdateCityUseCase;

public class UpdateAddressUseCaseImpl implements UpdateAddressUseCase {

    private final AddressGateway addressGateway;
    private final GetAddressByIdUseCase getAddressById;
    private final UpdateCityUseCase updateCityUseCase;

    public UpdateAddressUseCaseImpl(AddressGateway addressGateway, GetAddressByIdUseCase getAddressById, UpdateCityUseCase updateCityUseCase) {
        this.addressGateway = addressGateway;
        this.getAddressById = getAddressById;
        this.updateCityUseCase = updateCityUseCase;
    }

    @Override
    public Address execute(Address address) {
        var currentAddress = getAddressById.execute(address.getId());
        var city = updateCityUseCase.execute(address.getCity());

        ObjectMapperUtil.mapProperties(address, currentAddress);
        currentAddress.setCity(city);
       return addressGateway.update(address);
    }
}
