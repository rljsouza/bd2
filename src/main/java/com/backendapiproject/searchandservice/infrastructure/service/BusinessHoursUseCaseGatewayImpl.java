package com.backendapiproject.searchandservice.infrastructure.service;

import com.backendapiproject.searchandservice.application.gateway.BusinessHoursUseCaseGateway;
import com.backendapiproject.searchandservice.core.domain.BusinessHours;
import com.backendapiproject.searchandservice.core.exception.NotFoundException;
import com.backendapiproject.searchandservice.infrastructure.mapper.BusinessHoursMapper;
import com.backendapiproject.searchandservice.infrastructure.repository.BusinessHoursRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BusinessHoursUseCaseGatewayImpl implements BusinessHoursUseCaseGateway {

    private final BusinessHoursRepository repository;
    private final BusinessHoursMapper mapper;


    @Override
    public List<BusinessHours> create(List<BusinessHours> businessHours) {
     return mapper.toBusinessHour(repository.saveAll(mapper.toBusinessHoursEntity(businessHours)));
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public BusinessHours getBusinessHoursById(Long id) {
       var dto = repository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("BusinessHours não encontrado: ID "+ id);
        });

      return mapper.toBusinessHours(dto);
    }

    @Override
    public List<BusinessHours> listBusinessHours() {
        return mapper.toBusinessHour(repository.findAll());
    }
}
