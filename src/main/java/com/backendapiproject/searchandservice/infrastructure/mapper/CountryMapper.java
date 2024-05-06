package com.backendapiproject.searchandservice.infrastructure.mapper;

import com.backendapiproject.searchandservice.core.domain.Country;
import com.backendapiproject.searchandservice.infrastructure.entity.CountryEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class CountryMapper {

    private final ModelMapper mapper;

    public CountryEntity toCountryEntity(Country country){
        return mapper.map(country, CountryEntity.class);
    }

    public Country toCountry(CountryEntity country){
        return mapper.map(country,  Country.class);
    }

    public List<Country> toCountry(List<CountryEntity> countries){
        return countries.stream().map(this::toCountry).collect(Collectors.toList());
    }


}
