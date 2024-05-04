package com.backendapiproject.searchandservice.infrastructure.config.main;

import com.backendapiproject.searchandservice.application.gateway.StateGateway;
import com.backendapiproject.searchandservice.application.usecaseImpl.CreateStateUseCaseImpl;
import com.backendapiproject.searchandservice.application.usecaseImpl.DeleteStateByIdUseCaseImpl;
import com.backendapiproject.searchandservice.application.usecaseImpl.GetStateByIdUseCaseImpl;
import com.backendapiproject.searchandservice.application.usecaseImpl.ListStateUseCaseImpl;
import com.backendapiproject.searchandservice.application.usecaseImpl.UpdateStateUseCaseImpl;
import com.backendapiproject.searchandservice.usecase.CreateStateUseCase;
import com.backendapiproject.searchandservice.usecase.DeleteStateByIdUseCase;
import com.backendapiproject.searchandservice.usecase.GetCountryByIdUseCase;
import com.backendapiproject.searchandservice.usecase.GetStateByIdUseCase;
import com.backendapiproject.searchandservice.usecase.ListStateUseCase;
import com.backendapiproject.searchandservice.usecase.UpdateStateUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StateMain {

    @Bean
    public CreateStateUseCase createStateUseCase(StateGateway StateGateway, GetCountryByIdUseCase getCountryByIdUseCase){
        return new CreateStateUseCaseImpl(StateGateway, getCountryByIdUseCase);
    }
    @Bean
    public GetStateByIdUseCase getStateByIdUseCase(StateGateway StateGateway){
        return new GetStateByIdUseCaseImpl(StateGateway);
    }
    @Bean
    public UpdateStateUseCase updateStateUseCase(StateGateway StateGateway, GetStateByIdUseCase getStateByIdUseCase, GetCountryByIdUseCase getCountryByIdUseCase){
        return new UpdateStateUseCaseImpl(StateGateway, getStateByIdUseCase, getCountryByIdUseCase);
    }

    @Bean
    public DeleteStateByIdUseCase deleteStateByIdUseCase(StateGateway StateGateway, GetStateByIdUseCase getStateByIdUseCase){
        return new DeleteStateByIdUseCaseImpl(StateGateway, getStateByIdUseCase);
    }

    @Bean
    public ListStateUseCase listStateUseCase(StateGateway StateGateway){
        return new ListStateUseCaseImpl(StateGateway);
    }
}
