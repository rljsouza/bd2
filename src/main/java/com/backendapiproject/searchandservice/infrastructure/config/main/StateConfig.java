package com.backendapiproject.searchandservice.infrastructure.config.main;

import com.backendapiproject.searchandservice.application.gateway.StateGateway;
import com.backendapiproject.searchandservice.application.usecaseImpl.CreateStateUseCaseImpl;
import com.backendapiproject.searchandservice.application.usecaseImpl.DeleteStateByIdUseCaseImpl;
import com.backendapiproject.searchandservice.application.usecaseImpl.GetStateByIdUseCaseImpl;
import com.backendapiproject.searchandservice.application.usecaseImpl.UpdateStateUseCaseImpl;
import com.backendapiproject.searchandservice.usecase.CreateCountryUseCase;
import com.backendapiproject.searchandservice.usecase.CreateStateUseCase;
import com.backendapiproject.searchandservice.usecase.DeleteStateByIdUseCase;
import com.backendapiproject.searchandservice.usecase.GetStateByIdUseCase;
import com.backendapiproject.searchandservice.usecase.UpdateCountryUseCase;
import com.backendapiproject.searchandservice.usecase.UpdateStateUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StateConfig {

    @Bean
    public CreateStateUseCase createStateUseCase(StateGateway StateGateway, CreateCountryUseCase createCountryUseCase){
        return new CreateStateUseCaseImpl(StateGateway, createCountryUseCase);
    }
    @Bean
    public GetStateByIdUseCase getStateByIdUseCase(StateGateway StateGateway){
        return new GetStateByIdUseCaseImpl(StateGateway);
    }
    @Bean
    public UpdateStateUseCase updateStateUseCase(StateGateway StateGateway, GetStateByIdUseCase getStateByIdUseCase, UpdateCountryUseCase updateCountryUseCase){
        return new UpdateStateUseCaseImpl(StateGateway, getStateByIdUseCase, updateCountryUseCase);
    }

    @Bean
    public DeleteStateByIdUseCase deleteStateByIdUseCase(StateGateway StateGateway, GetStateByIdUseCase getStateByIdUseCase){
        return new DeleteStateByIdUseCaseImpl(StateGateway, getStateByIdUseCase);
    }
}
