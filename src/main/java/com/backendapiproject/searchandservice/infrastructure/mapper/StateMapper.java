package com.backendapiproject.searchandservice.infrastructure.mapper;

import com.backendapiproject.searchandservice.core.domain.State;
import com.backendapiproject.searchandservice.infrastructure.entity.StateEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

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


}
