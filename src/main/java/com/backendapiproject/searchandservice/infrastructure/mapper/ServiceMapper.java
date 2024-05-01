package com.backendapiproject.searchandservice.infrastructure.mapper;

import com.backendapiproject.searchandservice.core.domain.Service;
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

    public ServiceEntity toServiceEntity(Service service){
        return mapper.map(service, ServiceEntity.class);
    }

    public Service toService(ServiceEntity service){
        return mapper.map(service,  Service.class);
    }

    public List<Service> toService(List<ServiceEntity> services){
        return services.stream().map(this::toService).collect(Collectors.toList());
    }

}
