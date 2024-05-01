package com.backendapiproject.searchandservice.application.usecaseImpl;

import com.backendapiproject.searchandservice.application.gateway.CityGateway;
import com.backendapiproject.searchandservice.usecase.DeleteCityByIdUseCase;
import com.backendapiproject.searchandservice.usecase.GetCityByIdUseCase;

public class DeleteCityByIdUseCaseImpl implements DeleteCityByIdUseCase {

    private final CityGateway cityGateway;
    private final GetCityByIdUseCase getCityById;

    public DeleteCityByIdUseCaseImpl(CityGateway cityGateway, GetCityByIdUseCase getCityById) {
        this.cityGateway = cityGateway;
        this.getCityById = getCityById;
    }

    @Override
    public void execute(Long id) {
        getCityById.execute(id);
        cityGateway.deleteById(id);
    }

}
