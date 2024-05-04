package com.backendapiproject.searchandservice.infrastructure.mapper;

import com.backendapiproject.searchandservice.core.domain.Service;
import com.backendapiproject.searchandservice.infrastructure.dto.request.DayRequest;
import com.backendapiproject.searchandservice.infrastructure.dto.request.ServiceRequest;
import com.backendapiproject.searchandservice.infrastructure.entity.ServiceEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ServiceMapper {

    private final ModelMapper mapper;
    private final BusinessHoursMapper businessHoursMapper;

    public ServiceEntity toServiceEntity(Service service){
        return mapper.map(service, ServiceEntity.class);
    }

    public Service toService(ServiceEntity service){
        return mapper.map(service,  Service.class);
    }

    public List<Service> toService(List<ServiceEntity> services){
        return services.stream().map(this::toService).collect(Collectors.toList());
    }

    public Service toService(ServiceRequest request){
        //var businessHours = businessHoursMapper.businessHours(request.getBusinessHours());
        var service =  mapper.map(request,  Service.class);
     //   service.setBusinessHours(businessHours);
        return service;
    }



}
