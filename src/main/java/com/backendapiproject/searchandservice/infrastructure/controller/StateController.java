package com.backendapiproject.searchandservice.infrastructure.controller;

import com.backendapiproject.searchandservice.core.domain.State;
import com.backendapiproject.searchandservice.usecase.CreateStateUseCase;
import com.backendapiproject.searchandservice.usecase.DeleteStateByIdUseCase;
import com.backendapiproject.searchandservice.usecase.GetStateByIdUseCase;
import com.backendapiproject.searchandservice.usecase.UpdateStateUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/v1/api/state")
@RequiredArgsConstructor
public class StateController {

    private final CreateStateUseCase createStateUseCase;
    private final UpdateStateUseCase updateStateUseCase;
    private final GetStateByIdUseCase getStateByIdUseCase;
    private final DeleteStateByIdUseCase deleteStateByIdUseCase;

    @PostMapping
    public ResponseEntity<State> saveState(@RequestBody State state) {
        var savedState = createStateUseCase.execute(state);
        return new ResponseEntity<>(savedState, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<State> getStateById(@PathVariable Long id) {
        var state = getStateByIdUseCase.execute(id);
        return new ResponseEntity<>(state, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<State> updateState(@PathVariable Long id, @RequestBody State state) {
        state.setId(id);
        State updatedState = updateStateUseCase.execute(state);
        return new ResponseEntity<>(updatedState, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStateById(@PathVariable Long id) {
        deleteStateByIdUseCase.execute(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
