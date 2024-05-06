package com.backendapiproject.searchandservice.infrastructure.config.main;

import com.backendapiproject.searchandservice.application.gateway.AddressGateway;
import com.backendapiproject.searchandservice.application.usecaseImpl.CreateAddressUseCaseImpl;
import com.backendapiproject.searchandservice.application.usecaseImpl.DeleteAddressByIdUseCaseImpl;
import com.backendapiproject.searchandservice.application.usecaseImpl.GetAddressByIdUseCaseImpl;
import com.backendapiproject.searchandservice.application.usecaseImpl.UpdateAddressUseCaseImpl;
import com.backendapiproject.searchandservice.usecase.CreateAddressUseCase;
import com.backendapiproject.searchandservice.usecase.DeleteAddressByIdUseCase;
import com.backendapiproject.searchandservice.usecase.GetAddressByIdUseCase;
import com.backendapiproject.searchandservice.usecase.GetCityByIdUseCase;
import com.backendapiproject.searchandservice.usecase.UpdateAddressUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AddressConfig {

    @Bean
    public CreateAddressUseCase createAddressUseCase(AddressGateway addressGateway, GetCityByIdUseCase getCityByIdUseCase){
        return new CreateAddressUseCaseImpl(addressGateway, getCityByIdUseCase);
    }
    @Bean
    public GetAddressByIdUseCase getAddressByIdUseCase(AddressGateway addressGateway){
        return new GetAddressByIdUseCaseImpl(addressGateway);
    }
    @Bean
    public UpdateAddressUseCase updateAddressUseCase(AddressGateway addressGateway, GetAddressByIdUseCase getAddressByIdUseCase, GetCityByIdUseCase getCityByIdUseCase){
        return new UpdateAddressUseCaseImpl(addressGateway, getAddressByIdUseCase, getCityByIdUseCase);
    }

    @Bean
    public DeleteAddressByIdUseCase deleteAddressByIdUseCase(AddressGateway addressGateway, GetAddressByIdUseCase getAddressByIdUseCase){
        return new DeleteAddressByIdUseCaseImpl(addressGateway, getAddressByIdUseCase);
    }

}