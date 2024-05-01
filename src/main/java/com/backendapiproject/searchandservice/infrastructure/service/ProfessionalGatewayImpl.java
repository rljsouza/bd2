package com.backendapiproject.searchandservice.infrastructure.service;

import com.backendapiproject.searchandservice.application.gateway.ProfessionalGateway;
import com.backendapiproject.searchandservice.core.domain.Professional;
import com.backendapiproject.searchandservice.infrastructure.mapper.ProfessionalMapper;
import com.backendapiproject.searchandservice.infrastructure.repository.ProfessionalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class ProfessionalGatewayImpl implements ProfessionalGateway {

    private final ProfessionalRepository repository;
    private final ProfessionalMapper mapper;

    @Override
    public Professional save(Professional professional) {
        var professionalEntity = repository.save(mapper.toProfessionalEntity(professional));
        return mapper.toProfessional(professionalEntity);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Professional update(Professional professional) {
        var professionalEntity = repository.save(mapper.toProfessionalEntity(professional));
        return mapper.toProfessional(professionalEntity);
    }

    @Override
    public Optional<Professional> findById(Long id) {
        var professionalEntity = repository.findById(id);
        return professionalEntity.map(mapper::toProfessional);
    }

    @Override
    public List<Professional> findAll() {
        return mapper.toProfessional(repository.findAll());
    }
}
