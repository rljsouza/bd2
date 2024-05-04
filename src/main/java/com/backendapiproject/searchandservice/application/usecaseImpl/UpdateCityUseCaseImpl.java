package com.backendapiproject.searchandservice.application.usecaseImpl;

import com.backendapiproject.searchandservice.application.gateway.CityGateway;
import com.backendapiproject.searchandservice.application.util.ObjectMapperUtil;
import com.backendapiproject.searchandservice.core.domain.City;
import com.backendapiproject.searchandservice.usecase.GetCityByIdUseCase;
import com.backendapiproject.searchandservice.usecase.GetStateByIdUseCase;
import com.backendapiproject.searchandservice.usecase.UpdateCityUseCase;
import jakarta.validation.constraints.NotNull;


public class UpdateCityUseCaseImpl implements UpdateCityUseCase {

    private final CityGateway cityGateway;
    private final GetCityByIdUseCase getCityById;
    private final GetStateByIdUseCase getStateByIdUseCase;

    public UpdateCityUseCaseImpl(CityGateway cityGateway, GetCityByIdUseCase getCityById, GetStateByIdUseCase getStateByIdUseCase) {
        this.cityGateway = cityGateway;
        this.getCityById = getCityById;
        this.getStateByIdUseCase = getStateByIdUseCase;
    }


    @Override
    public City execute(City city, @NotNull Long id) {
        var currentCity = getCityById.execute(id);
        var state = getStateByIdUseCase.execute(city.getState().getId());
        ObjectMapperUtil.mapProperties(city, currentCity);
        currentCity.setState(state);
        return cityGateway.update(currentCity);
    }

}
