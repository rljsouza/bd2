package com.backendapiproject.searchandservice.infrastructure.config.main;

import com.backendapiproject.searchandservice.application.gateway.CityGateway;
import com.backendapiproject.searchandservice.application.usecaseImpl.CreateCityUseCaseImpl;
import com.backendapiproject.searchandservice.application.usecaseImpl.DeleteCityByIdUseCaseImpl;
import com.backendapiproject.searchandservice.application.usecaseImpl.GetCityByIdUseCaseImpl;
import com.backendapiproject.searchandservice.application.usecaseImpl.ListCityUseCaseImpl;
import com.backendapiproject.searchandservice.application.usecaseImpl.UpdateCityUseCaseImpl;
import com.backendapiproject.searchandservice.usecase.CreateCityUseCase;
import com.backendapiproject.searchandservice.usecase.DeleteCityByIdUseCase;
import com.backendapiproject.searchandservice.usecase.GetCityByIdUseCase;
import com.backendapiproject.searchandservice.usecase.GetStateByIdUseCase;
import com.backendapiproject.searchandservice.usecase.ListCityUseCase;
import com.backendapiproject.searchandservice.usecase.UpdateCityUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CityConfig {

    @Bean
    public CreateCityUseCase createCityUseCase(CityGateway CityGateway, GetStateByIdUseCase getStateByIdUseCase){
        return new CreateCityUseCaseImpl(CityGateway, getStateByIdUseCase);
    }
    @Bean
    public GetCityByIdUseCase getCityByIdUseCase(CityGateway CityGateway){
        return new GetCityByIdUseCaseImpl(CityGateway);
    }
    @Bean
    public UpdateCityUseCase updateCityUseCase(CityGateway CityGateway, GetCityByIdUseCase getCityByIdUseCase, GetStateByIdUseCase getStateByIdUseCase){
        return new UpdateCityUseCaseImpl(CityGateway, getCityByIdUseCase, getStateByIdUseCase);
    }

    @Bean
    public DeleteCityByIdUseCase deleteCityByIdUseCase(CityGateway CityGateway, GetCityByIdUseCase getCityByIdUseCase){
        return new DeleteCityByIdUseCaseImpl(CityGateway, getCityByIdUseCase);
    }

    @Bean
    public ListCityUseCase listCityUseCase(CityGateway cityGateway){
        return new ListCityUseCaseImpl(cityGateway);
    }

}
