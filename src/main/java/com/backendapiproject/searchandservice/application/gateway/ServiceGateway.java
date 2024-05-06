package com.backendapiproject.searchandservice.application.gateway;

import com.backendapiproject.searchandservice.core.domain.Service;
import com.backendapiproject.searchandservice.usecase.ListServiceAvailableUseCase;

import java.util.List;
import java.util.Optional;


public interface ServiceGateway {

    Service save(Service service);
    void deleteById(Long id);
    Service update(Service service);
    Optional<Service> findById(Long id);
    List<Service> findAll();
}
