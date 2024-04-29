package com.backendapiproject.searchandservice.application.usecaseImpl;

import com.backendapiproject.searchandservice.application.gateway.CityGateway;
import com.backendapiproject.searchandservice.application.util.ObjectMapperUtil;
import com.backendapiproject.searchandservice.core.domain.City;
import com.backendapiproject.searchandservice.usecase.GetCityByIdUseCase;
import com.backendapiproject.searchandservice.usecase.UpdateCityUseCase;
import com.backendapiproject.searchandservice.usecase.UpdateStateUseCase;


public class UpdateCityUseCaseImpl implements UpdateCityUseCase {

    private final CityGateway cityGateway;
    private final GetCityByIdUseCase getCityById;
    private final UpdateStateUseCase updateStateUseCase;

    public UpdateCityUseCaseImpl(CityGateway cityGateway, GetCityByIdUseCase getCityById, UpdateStateUseCase updateStateUseCase) {
        this.cityGateway = cityGateway;
        this.getCityById = getCityById;
        this.updateStateUseCase = updateStateUseCase;
    }


    @Override
    public City execute(City city) {
        var currentCity = getCityById.execute(city.getId());
        var state = updateStateUseCase.execute(city.getState());

        ObjectMapperUtil.mapProperties(city, currentCity);
        currentCity.setState(state);
        return cityGateway.update(currentCity);
    }

}
