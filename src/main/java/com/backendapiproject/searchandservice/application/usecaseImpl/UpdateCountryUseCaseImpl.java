package com.backendapiproject.searchandservice.application.usecaseImpl;

import com.backendapiproject.searchandservice.application.gateway.CountryGateway;
import com.backendapiproject.searchandservice.application.util.ObjectMapperUtil;
import com.backendapiproject.searchandservice.core.domain.Country;
import com.backendapiproject.searchandservice.usecase.GetCountryByIdUseCase;
import com.backendapiproject.searchandservice.usecase.UpdateCountryUseCase;

public class UpdateCountryUseCaseImpl  implements UpdateCountryUseCase {

    private final CountryGateway countryGateway;
    private final GetCountryByIdUseCase getCountryByIdUseCase;

    public UpdateCountryUseCaseImpl(CountryGateway countryGateway, GetCountryByIdUseCase getCountryByIdUseCase) {
        this.countryGateway = countryGateway;
        this.getCountryByIdUseCase = getCountryByIdUseCase;
    }


    @Override
    public Country execute(Country country) {
        var currentCountry = getCountryByIdUseCase.execute(country.getId());
        ObjectMapperUtil.mapProperties(country, currentCountry);
        return countryGateway.update(currentCountry);
    }
}
