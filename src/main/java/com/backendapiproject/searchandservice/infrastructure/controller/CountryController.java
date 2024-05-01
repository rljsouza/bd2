package com.backendapiproject.searchandservice.infrastructure.controller;

import com.backendapiproject.searchandservice.core.domain.Country;
import com.backendapiproject.searchandservice.usecase.CreateCountryUseCase;
import com.backendapiproject.searchandservice.usecase.DeleteCountryByIdUseCase;
import com.backendapiproject.searchandservice.usecase.GetCountryByIdUseCase;
import com.backendapiproject.searchandservice.usecase.UpdateCountryUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/v1/api/country")
@RequiredArgsConstructor
public class CountryController {

    private final CreateCountryUseCase createCountryUseCase;
    private final DeleteCountryByIdUseCase deleteCountryByIdUseCase;
    private final UpdateCountryUseCase updateCountryUseCase;
    private final GetCountryByIdUseCase getCountryByIdUseCase;

    @PostMapping
    public ResponseEntity<Country> saveCountry(@RequestBody Country country) {
        var savedCountry = createCountryUseCase.execute(country);
        return new ResponseEntity<>(savedCountry, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Country> getCountryById(@PathVariable Long id) {
        var country = getCountryByIdUseCase.execute(id);
        return new ResponseEntity<>(country, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Country> updateCountry(@PathVariable Long id, @RequestBody Country country) {
        country.setId(id);
        var updatedCountry = updateCountryUseCase.execute(country);
        return new ResponseEntity<>(updatedCountry, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCountryById(@PathVariable Long id) {
        deleteCountryByIdUseCase.execute(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
