package com.backendapiproject.searchandservice.application.usecaseImpl;

import com.backendapiproject.searchandservice.application.gateway.CountryGateway;
import com.backendapiproject.searchandservice.usecase.DeleteCountryByIdUseCase;
import com.backendapiproject.searchandservice.usecase.GetCountryByIdUseCase;

public class DeleteCountryByIdUseCaseImpl implements DeleteCountryByIdUseCase {

    private final CountryGateway countryGateway;
    private final GetCountryByIdUseCase getCountryById;

    public DeleteCountryByIdUseCaseImpl(CountryGateway countryGateway, GetCountryByIdUseCase getCountryById) {
        this.countryGateway = countryGateway;
        this.getCountryById = getCountryById;
    }

    @Override
    public void execute(Long id) {
        getCountryById.execute(id);
        countryGateway.deleteById(id);
    }
}
