package com.backendapiproject.searchandservice.infrastructure.controller;

import com.backendapiproject.searchandservice.core.domain.Country;
import com.backendapiproject.searchandservice.infrastructure.annotation.Authorize;
import com.backendapiproject.searchandservice.infrastructure.dto.request.CountryRequest;
import com.backendapiproject.searchandservice.infrastructure.mapper.CountryMapper;
import com.backendapiproject.searchandservice.usecase.CreateCountryUseCase;
import com.backendapiproject.searchandservice.usecase.DeleteCountryByIdUseCase;
import com.backendapiproject.searchandservice.usecase.GetCountryByIdUseCase;
import com.backendapiproject.searchandservice.usecase.ListCountryUseCase;
import com.backendapiproject.searchandservice.usecase.UpdateCountryUseCase;
import jakarta.validation.Valid;
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
@RequestMapping("/v1/api/country")
@RequiredArgsConstructor
public class CountryController {

    private final CreateCountryUseCase createCountryUseCase;
    private final DeleteCountryByIdUseCase deleteCountryByIdUseCase;
    private final UpdateCountryUseCase updateCountryUseCase;
    private final GetCountryByIdUseCase getCountryByIdUseCase;
    private final ListCountryUseCase listCountryUseCase;
    private final CountryMapper mapper;

    @PostMapping
    @Authorize(value = "ROLE_ADMIN")
    public ResponseEntity<Country> saveCountry(@RequestBody @Valid CountryRequest request) {
        var savedCountry = createCountryUseCase.execute(mapper.toCountry(request));
        return new ResponseEntity<>(savedCountry, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Country> getCountryById(@PathVariable Long id) {
        var country = getCountryByIdUseCase.execute(id);
        return new ResponseEntity<>(country, HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<Country>> listCountry() {
        var country = listCountryUseCase.execute();
        return new ResponseEntity<>(country, HttpStatus.OK);
    }


    @PutMapping("/{id}")
    @Authorize(value = "ROLE_ADMIN")
    public ResponseEntity<Country> updateCountry(@PathVariable Long id, @Valid @RequestBody CountryRequest request) {
        var updatedCountry = updateCountryUseCase.execute(mapper.toCountry(request), id);
        return new ResponseEntity<>(updatedCountry, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Authorize(value = "ROLE_ADMIN")
    public ResponseEntity<Void> deleteCountryById(@PathVariable Long id) {
        deleteCountryByIdUseCase.execute(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
