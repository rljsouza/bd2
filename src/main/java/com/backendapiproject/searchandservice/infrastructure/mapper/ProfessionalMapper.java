package com.backendapiproject.searchandservice.infrastructure.mapper;

import com.backendapiproject.searchandservice.core.domain.Professional;
import com.backendapiproject.searchandservice.infrastructure.dto.request.ProfessionalRequest;
import com.backendapiproject.searchandservice.infrastructure.dto.response.ProfessionalResponse;
import com.backendapiproject.searchandservice.infrastructure.entity.ProfessionalEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class ProfessionalMapper {

    private final ModelMapper mapper;

    public ProfessionalEntity toProfessionalEntity(Professional professional){
        return mapper.map(professional, ProfessionalEntity.class);
    }

    public Professional toProfessional(ProfessionalEntity professional){
        return mapper.map(professional,  Professional.class);
    }

    public List<Professional> toProfessional(List<ProfessionalEntity> professionals){
        return professionals.stream().map(this::toProfessional).collect(Collectors.toList());
    }

    public Professional toProfessional(ProfessionalRequest request){
        return mapper.map(request,  Professional.class);
    }

    public List<ProfessionalResponse> toProfessionalResponse(List<Professional> professionals){
        return professionals.stream().map(this::toProfessionalResponse).collect(Collectors.toList());
    }

    public ProfessionalResponse toProfessionalResponse(Professional professional){
        return mapper.map(professional,  ProfessionalResponse.class);
    }


}
