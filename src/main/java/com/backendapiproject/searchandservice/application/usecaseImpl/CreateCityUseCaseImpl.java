package com.backendapiproject.searchandservice.application.usecaseImpl;

import com.backendapiproject.searchandservice.application.gateway.CityGateway;
import com.backendapiproject.searchandservice.core.domain.City;
import com.backendapiproject.searchandservice.usecase.CreateCityUseCase;
import com.backendapiproject.searchandservice.usecase.CreateStateUseCase;
import com.backendapiproject.searchandservice.usecase.GetStateByIdUseCase;

public class CreateCityUseCaseImpl implements CreateCityUseCase {

    private final CityGateway cityGateway;
    private final GetStateByIdUseCase getStateByIdUseCase;

    public CreateCityUseCaseImpl(CityGateway cityGateway, GetStateByIdUseCase getStateByIdUseCase) {
        this.cityGateway = cityGateway;
        this.getStateByIdUseCase = getStateByIdUseCase;
    }


    @Override
    public City execute(City city) {
        var state = getStateByIdUseCase.execute(city.getState().getId());
        city.setState(state);
        return cityGateway.save(city);
    }
}
