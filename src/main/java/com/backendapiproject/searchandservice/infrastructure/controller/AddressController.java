package com.backendapiproject.searchandservice.infrastructure.controller;

import com.backendapiproject.searchandservice.core.domain.Address;
import com.backendapiproject.searchandservice.infrastructure.dto.request.AddressRequest;
import com.backendapiproject.searchandservice.infrastructure.mapper.AddressMapper;
import com.backendapiproject.searchandservice.usecase.CreateAddressUseCase;
import com.backendapiproject.searchandservice.usecase.DeleteAddressByIdUseCase;
import com.backendapiproject.searchandservice.usecase.GetAddressByIdUseCase;
import com.backendapiproject.searchandservice.usecase.UpdateAddressUseCase;
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

@RestController
@RequestMapping("/v1/api/address")
@RequiredArgsConstructor
public class AddressController {

    private final UpdateAddressUseCase updateAddressUseCase;
    private final CreateAddressUseCase createAddressUseCase;
    private final GetAddressByIdUseCase getAddressByIdUseCase;
    private final DeleteAddressByIdUseCase deleteAddressByIdUseCase;
    private final AddressMapper mapper;

    @PostMapping
    public ResponseEntity<Address> saveAddress(@RequestBody AddressRequest request) {
        var savedAddress = createAddressUseCase.execute(mapper.requestToAddress(request));
        return new ResponseEntity<Address>(savedAddress, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Address> getAddressById(@PathVariable Long id) {
        var address = getAddressByIdUseCase.execute(id);
        return new ResponseEntity<Address>(address, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Address> updateAddress(@PathVariable Long id, @RequestBody AddressRequest request) {
        Address updatedAddress = updateAddressUseCase.execute(mapper.requestToAddress(request), id);
        return new ResponseEntity<>(updatedAddress, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAddressById(@PathVariable Long id) {
        deleteAddressByIdUseCase.execute(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}