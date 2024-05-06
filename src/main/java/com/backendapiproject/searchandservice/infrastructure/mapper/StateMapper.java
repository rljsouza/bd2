package com.backendapiproject.searchandservice.infrastructure.mapper;

import com.backendapiproject.searchandservice.core.domain.State;
import com.backendapiproject.searchandservice.infrastructure.dto.request.StateRequest;
import com.backendapiproject.searchandservice.infrastructure.dto.response.StateResponse;
import com.backendapiproject.searchandservice.infrastructure.entity.StateEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class StateMapper {

    private final ModelMapper mapper;

    public StateEntity toStateEntity(State state){
        return mapper.map(state, StateEntity.class);
    }

    public State toSate(StateEntity state){
        return mapper.map(state,  State.class);
    }


    public List<State> toSate(List<StateEntity> stateEntities){
        return stateEntities.stream().map(this::toSate).collect(Collectors.toList());
    }

    public State toSate(StateRequest request){
        return mapper.map(request,  State.class);
    }

    public List<StateResponse> toSateResponse(List<State> stateEntities){
        return stateEntities.stream().map(this::toSateResponse).collect(Collectors.toList());
    }

    public StateResponse toSateResponse(State state){
        return mapper.map(state,  StateResponse.class);
    }





}
