package com.backendapiproject.searchandservice.infrastructure.controller;

import com.backendapiproject.searchandservice.core.domain.City;
import com.backendapiproject.searchandservice.infrastructure.annotation.Authorize;
import com.backendapiproject.searchandservice.infrastructure.dto.request.CityRequest;
import com.backendapiproject.searchandservice.infrastructure.dto.response.CityResponse;
import com.backendapiproject.searchandservice.infrastructure.mapper.CityMapper;
import com.backendapiproject.searchandservice.usecase.CreateCityUseCase;
import com.backendapiproject.searchandservice.usecase.DeleteCityByIdUseCase;
import com.backendapiproject.searchandservice.usecase.GetCityByIdUseCase;
import com.backendapiproject.searchandservice.usecase.ListCityUseCase;
import com.backendapiproject.searchandservice.usecase.UpdateCityUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/v1/api/city")
@RequiredArgsConstructor
public class CityController {

    private final CreateCityUseCase createCityUseCase;
    private final DeleteCityByIdUseCase deleteCityByIdUseCase;
    private final GetCityByIdUseCase getCityByIdUseCase;
    private final UpdateCityUseCase updateCityUseCase;
    private final ListCityUseCase listCityUseCase;
    private final CityMapper mapper;

    @PostMapping
    @Authorize(value = "ROLE_ADMIN")
    public ResponseEntity<CityResponse> saveCity(@RequestBody CityRequest request) {
        var savedCity = createCityUseCase.execute(mapper.toCity(request));
        return new ResponseEntity<>(mapper.toCityResponse(savedCity), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CityResponse> getCityById(@PathVariable Long id) {
        var city = getCityByIdUseCase.execute(id);
        return new ResponseEntity<>(mapper.toCityResponse(city), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CityResponse>> listCity() {
        var city = listCityUseCase.execute();
        return new ResponseEntity<>(mapper.toCityResponse(city), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @Authorize(value = "ROLE_ADMIN")
    public ResponseEntity<CityResponse> updateCity(@PathVariable Long id, @RequestBody CityRequest request) {
        var updatedCity = updateCityUseCase.execute(mapper.toCity(request), id);
        return new ResponseEntity<>(mapper.toCityResponse(updatedCity), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Authorize(value = "ROLE_ADMIN")
    public ResponseEntity<Void> deleteCityById(@PathVariable Long id) {
        deleteCityByIdUseCase.execute(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
