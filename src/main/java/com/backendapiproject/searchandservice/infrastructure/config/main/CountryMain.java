package com.backendapiproject.searchandservice.infrastructure.config.main;

import com.backendapiproject.searchandservice.application.gateway.CountryGateway;
import com.backendapiproject.searchandservice.application.usecaseImpl.CreateCountryUseCaseImpl;
import com.backendapiproject.searchandservice.application.usecaseImpl.DeleteCountryByIdUseCaseImpl;
import com.backendapiproject.searchandservice.application.usecaseImpl.GetCountryByIdUseCaseImpl;
import com.backendapiproject.searchandservice.application.usecaseImpl.ListCountryUseCaseImpl;
import com.backendapiproject.searchandservice.application.usecaseImpl.UpdateCountryUseCaseImpl;
import com.backendapiproject.searchandservice.usecase.CreateCountryUseCase;
import com.backendapiproject.searchandservice.usecase.DeleteCountryByIdUseCase;
import com.backendapiproject.searchandservice.usecase.GetCountryByIdUseCase;
import com.backendapiproject.searchandservice.usecase.ListCountryUseCase;
import com.backendapiproject.searchandservice.usecase.UpdateCountryUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CountryMain {

    @Bean
    public CreateCountryUseCase createCountryUseCase(CountryGateway CountryGateway){
        return new CreateCountryUseCaseImpl(CountryGateway);
    }
    @Bean
    public GetCountryByIdUseCase getCountryByIdUseCase(CountryGateway CountryGateway){
        return new GetCountryByIdUseCaseImpl(CountryGateway);
    }
    @Bean
    public UpdateCountryUseCase updateCountryUseCase(CountryGateway CountryGateway, GetCountryByIdUseCase getCountryByIdUseCase){
        return new UpdateCountryUseCaseImpl(CountryGateway, getCountryByIdUseCase);
    }

    @Bean
    public DeleteCountryByIdUseCase deleteCountryByIdUseCase(CountryGateway CountryGateway, GetCountryByIdUseCase getCountryByIdUseCase){
        return new DeleteCountryByIdUseCaseImpl(CountryGateway, getCountryByIdUseCase);
    }

    @Bean
    public ListCountryUseCase listCountryUseCase(CountryGateway countryGateway){
        return new ListCountryUseCaseImpl(countryGateway);
    }
}
