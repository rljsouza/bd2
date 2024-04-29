package com.backendapiproject.searchandservice.application.usecaseImpl;

import com.backendapiproject.searchandservice.application.gateway.CountryGateway;
import com.backendapiproject.searchandservice.core.domain.Country;
import com.backendapiproject.searchandservice.usecase.CreateCountryUseCase;

public class CreateCountryUseCaseImpl implements CreateCountryUseCase {

    private final CountryGateway countryGateway;

    public CreateCountryUseCaseImpl(CountryGateway countryGateway) {
        this.countryGateway = countryGateway;
    }


    @Override
    public Country execute(Country country) {
        return countryGateway.save(country);
    }
}
