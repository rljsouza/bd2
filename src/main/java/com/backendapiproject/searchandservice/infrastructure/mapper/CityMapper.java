package com.backendapiproject.searchandservice.infrastructure.mapper;

import com.backendapiproject.searchandservice.core.domain.City;
import com.backendapiproject.searchandservice.infrastructure.dto.request.CityRequest;
import com.backendapiproject.searchandservice.infrastructure.entity.CityEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class CityMapper {

    private final ModelMapper mapper;

    public CityEntity toCityEntity(City city){
        return mapper.map(city, CityEntity.class);
    }

    public City toCity(CityEntity city){
        return mapper.map(city,  City.class);
    }

    public List<City> toCity(List<CityEntity> cities){
        return cities.stream().map(this::toCity).collect(Collectors.toList());

    }

    public City toCity(CityRequest request){
        return mapper.map(request,  City.class);
    }



}
