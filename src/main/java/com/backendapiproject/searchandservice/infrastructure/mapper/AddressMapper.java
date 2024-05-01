package com.backendapiproject.searchandservice.infrastructure.mapper;

import com.backendapiproject.searchandservice.core.domain.Address;
import com.backendapiproject.searchandservice.infrastructure.entity.AddressEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class AddressMapper {

    private final ModelMapper mapper;

    public AddressEntity toAddressEntity(Address address){
        return mapper.map(address, AddressEntity.class);
    }

    public Address toAddress(AddressEntity address){
        return mapper.map(address, Address.class);
    }


}
