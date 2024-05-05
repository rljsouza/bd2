package com.backendapiproject.searchandservice.infrastructure.controller;

import com.backendapiproject.searchandservice.core.domain.City;
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

    @PostMapping
    public ResponseEntity<City> saveCity(@RequestBody City city) {
        var savedCity = createCityUseCase.execute(city);
        return new ResponseEntity<>(savedCity, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<City> getCityById(@PathVariable Long id) {
        var city = getCityByIdUseCase.execute(id);
        return new ResponseEntity<>(city, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<City>> listCity() {
        var city = listCityUseCase.execute();
        return new ResponseEntity<>(city, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<City> updateCity(@PathVariable Long id, @RequestBody City city) {
        city.setId(id);
        var updatedCity = updateCityUseCase.execute(city);
        return new ResponseEntity<>(updatedCity, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCityById(@PathVariable Long id) {
        deleteCityByIdUseCase.execute(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
