package com.backendapiproject.searchandservice.application.usecaseImpl;

import com.backendapiproject.searchandservice.application.gateway.CountryGateway;
import com.backendapiproject.searchandservice.core.domain.Country;
import com.backendapiproject.searchandservice.usecase.ListCountryUseCase;

import java.util.List;

public class ListCountryUseCaseImpl implements ListCountryUseCase {

    private final CountryGateway countryGateway;

    public ListCountryUseCaseImpl(CountryGateway countryGateway) {
        this.countryGateway = countryGateway;
    }

    @Override
    public List<Country> execute() {
        return countryGateway.findAll();
    }
}
