package com.backendapiproject.searchandservice.infrastructure.service;

import com.backendapiproject.searchandservice.application.gateway.AddressGateway;
import com.backendapiproject.searchandservice.core.domain.Address;
import com.backendapiproject.searchandservice.infrastructure.mapper.AddressMapper;
import com.backendapiproject.searchandservice.infrastructure.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class AddressGatewayImpl implements AddressGateway {

    private final AddressRepository repository;
    private final AddressMapper mapper;

    @Override
    public Address save(Address address) {
        var salvedAddress = repository.save(mapper.toAddressEntity(address));
        return mapper.toAddress(salvedAddress);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Address update(Address address) {
        var addressEntity = repository.save(mapper.toAddressEntity(address));
        return mapper.toAddress(addressEntity);
    }

    @Override
    public Optional<Address> findById(Long id) {
        var addressEntityOptional = repository.findById(id);
        return addressEntityOptional.map(mapper::toAddress);
    }


}
