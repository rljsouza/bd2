package com.backendapiproject.searchandservice.infrastructure.controller;

import com.backendapiproject.searchandservice.core.domain.State;
import com.backendapiproject.searchandservice.infrastructure.annotation.Authorize;
import com.backendapiproject.searchandservice.infrastructure.dto.request.StateRequest;
import com.backendapiproject.searchandservice.infrastructure.dto.response.StateResponse;
import com.backendapiproject.searchandservice.infrastructure.mapper.StateMapper;
import com.backendapiproject.searchandservice.usecase.CreateStateUseCase;
import com.backendapiproject.searchandservice.usecase.DeleteStateByIdUseCase;
import com.backendapiproject.searchandservice.usecase.GetStateByIdUseCase;
import com.backendapiproject.searchandservice.usecase.ListStateUseCase;
import com.backendapiproject.searchandservice.usecase.UpdateStateUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;


@RestController
@RequestMapping("/v1/api/state")
@RequiredArgsConstructor
public class StateController {

    private final CreateStateUseCase createStateUseCase;
    private final UpdateStateUseCase updateStateUseCase;
    private final GetStateByIdUseCase getStateByIdUseCase;
    private final DeleteStateByIdUseCase deleteStateByIdUseCase;
    private final ListStateUseCase listStateUseCase;
    private final StateMapper mapper;

    @PostMapping
    @Authorize(value = "ROLE_ADMIN")
    public ResponseEntity<StateResponse> saveState(@RequestBody @Valid StateRequest request) {
        var savedState = createStateUseCase.execute(mapper.toSate(request));
        return new ResponseEntity<>(mapper.toSateResponse(savedState), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StateResponse> getStateById(@PathVariable Long id) {
        var state = getStateByIdUseCase.execute(id);
        return new ResponseEntity<>(mapper.toSateResponse(state), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<StateResponse>> listState() {
        var state = listStateUseCase.execute();
        return new ResponseEntity<>(mapper.toSateResponse(state), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @Authorize(value = "ROLE_ADMIN")
    public ResponseEntity<StateResponse> updateState(@PathVariable Long id, @Valid @RequestBody StateRequest request) {
        State updatedState = updateStateUseCase.execute(mapper.toSate(request), id);
        return new ResponseEntity<>(mapper.toSateResponse(updatedState), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStateById(@PathVariable Long id) {
        deleteStateByIdUseCase.execute(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
