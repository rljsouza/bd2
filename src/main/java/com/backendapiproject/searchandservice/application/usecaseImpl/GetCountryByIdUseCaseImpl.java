package com.backendapiproject.searchandservice.application.usecaseImpl;

import com.backendapiproject.searchandservice.application.gateway.CountryGateway;
import com.backendapiproject.searchandservice.core.domain.Country;
import com.backendapiproject.searchandservice.core.exception.NotFoundException;
import com.backendapiproject.searchandservice.usecase.GetCountryByIdUseCase;

public class GetCountryByIdUseCaseImpl implements GetCountryByIdUseCase {

    private final CountryGateway countryGateway;

    public GetCountryByIdUseCaseImpl(CountryGateway countryGateway) {
        this.countryGateway = countryGateway;
    }

    @Override
    public Country execute(Long id) {
        return countryGateway.findById(id)
                .orElseThrow(() -> new NotFoundException("País não encontrado para o ID: " + id));
    }
}
