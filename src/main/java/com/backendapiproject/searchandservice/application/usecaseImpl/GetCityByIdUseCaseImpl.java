package com.backendapiproject.searchandservice.application.usecaseImpl;

import com.backendapiproject.searchandservice.application.gateway.CityGateway;
import com.backendapiproject.searchandservice.core.domain.City;
import com.backendapiproject.searchandservice.core.exception.NotFoundException;
import com.backendapiproject.searchandservice.usecase.GetCityByIdUseCase;

public class GetCityByIdUseCaseImpl implements GetCityByIdUseCase {

    private final CityGateway cityGateway;

    public GetCityByIdUseCaseImpl(CityGateway cityGateway) {
        this.cityGateway = cityGateway;
    }

    @Override
    public City execute(Long id) {
        return cityGateway.findById(id)
                .orElseThrow(() -> new NotFoundException("Cidade não encontrado para o ID: " + id));
    }

}
