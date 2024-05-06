package com.backendapiproject.searchandservice.application.usecaseImpl;

import com.backendapiproject.searchandservice.application.gateway.CityGateway;
import com.backendapiproject.searchandservice.core.domain.City;
import com.backendapiproject.searchandservice.usecase.ListCityUseCase;

import java.util.List;

public class ListCityUseCaseImpl implements ListCityUseCase {

    private final CityGateway cityGateway;

    public ListCityUseCaseImpl(CityGateway cityGateway) {
        this.cityGateway = cityGateway;
    }

    @Override
    public List<City> execute() {
        return cityGateway.findAll();
    }

}
