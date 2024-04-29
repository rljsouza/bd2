package com.backendapiproject.searchandservice.application.usecaseImpl;

import com.backendapiproject.searchandservice.application.gateway.CityGateway;
import com.backendapiproject.searchandservice.core.domain.City;
import com.backendapiproject.searchandservice.usecase.CreateCityUseCase;
import com.backendapiproject.searchandservice.usecase.CreateStateUseCase;

public class CreateCityUseCaseImpl implements CreateCityUseCase {

    private final CityGateway cityGateway;
    private final CreateStateUseCase createStateUseCase;

    public CreateCityUseCaseImpl(CityGateway cityGateway, CreateStateUseCase createStateUseCase) {
        this.cityGateway = cityGateway;
        this.createStateUseCase = createStateUseCase;
    }


    @Override
    public City execute(City city) {
        var state = createStateUseCase.execute(city.getState());
        city.setState(state);
        return cityGateway.save(city);
    }
}
