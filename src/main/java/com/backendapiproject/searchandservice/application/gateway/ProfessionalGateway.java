package com.backendapiproject.searchandservice.application.gateway;

import com.backendapiproject.searchandservice.core.domain.Professional;

import java.util.List;
import java.util.Optional;


public interface ProfessionalGateway {

    Professional save(Professional country);
    void deleteById(Long id);
    Professional update(Professional country);
    Optional<Professional> findById(Long id);
    List<Professional> findAll();
}
