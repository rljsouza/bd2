package com.backendapiproject.searchandservice.infrastructure.mapper;

import com.backendapiproject.searchandservice.core.domain.BusinessHours;
import com.backendapiproject.searchandservice.infrastructure.dto.request.BusinessHoursRequest;
import com.backendapiproject.searchandservice.infrastructure.entity.BusinessHoursEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class BusinessHoursMapper {

    private final ModelMapper mapper;

    public BusinessHours toBusinessHours (BusinessHoursRequest request){
        var businessHours  = mapper.map(request, BusinessHours.class);
        return businessHours;
    }

    public BusinessHoursEntity toBusinessHoursEntity(BusinessHours business){
        var businessHours  = mapper.map(business, BusinessHoursEntity.class);
        return businessHours;
    }


    public BusinessHours toBusinessHours(BusinessHoursEntity business){
       return mapper.map(business, BusinessHours.class);

    }
    public List<BusinessHours> toBusinessHour (List<BusinessHoursEntity> businessHoursEntities ){
        return businessHoursEntities.stream().map(this::toBusinessHours).collect(Collectors.toList());
    }


    public List<BusinessHours> toBusinessHours (List<BusinessHoursRequest> request){
        return request.stream().map(this::toBusinessHours).collect(Collectors.toList());
    }
    public List<BusinessHoursEntity> toBusinessHoursEntity(List<BusinessHours> request){
        return request.stream().map(this::toBusinessHoursEntity).collect(Collectors.toList());
    }

}
