package com.backendapiproject.searchandservice.application.usecaseImpl;

import com.backendapiproject.searchandservice.application.gateway.AddressGateway;
import com.backendapiproject.searchandservice.application.util.ObjectMapperUtil;
import com.backendapiproject.searchandservice.core.domain.Address;
import com.backendapiproject.searchandservice.usecase.GetAddressByIdUseCase;
import com.backendapiproject.searchandservice.usecase.GetCityByIdUseCase;
import com.backendapiproject.searchandservice.usecase.UpdateAddressUseCase;

public class UpdateAddressUseCaseImpl implements UpdateAddressUseCase {

    private final AddressGateway addressGateway;
    private final GetAddressByIdUseCase getAddressById;
    private final GetCityByIdUseCase getCityByIdUseCase;

    public UpdateAddressUseCaseImpl(AddressGateway addressGateway, GetAddressByIdUseCase getAddressById, GetCityByIdUseCase getCityByIdUseCase) {
        this.addressGateway = addressGateway;
        this.getAddressById = getAddressById;
        this.getCityByIdUseCase = getCityByIdUseCase;
    }

    @Override
    public Address execute(Address address) {
        var currentAddress = getAddressById.execute(address.getId());
        var city = getCityByIdUseCase.execute(address.getCity().getId());
        ObjectMapperUtil.mapProperties(address, currentAddress);
        currentAddress.setCity(city);
       return addressGateway.update(address);
    }
}
