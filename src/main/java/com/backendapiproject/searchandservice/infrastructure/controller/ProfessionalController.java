package com.backendapiproject.searchandservice.infrastructure.controller;

import com.backendapiproject.searchandservice.core.domain.Professional;
import com.backendapiproject.searchandservice.core.domain.Service;
import com.backendapiproject.searchandservice.infrastructure.annotation.Authorize;
import com.backendapiproject.searchandservice.infrastructure.dto.request.ProfessionalRequest;
import com.backendapiproject.searchandservice.infrastructure.mapper.ProfessionalMapper;
import com.backendapiproject.searchandservice.usecase.AddServiceUseCase;
import com.backendapiproject.searchandservice.usecase.CreateProfessionalUseCase;
import com.backendapiproject.searchandservice.usecase.DeleteProfessionalByIdUseCase;
import com.backendapiproject.searchandservice.usecase.GetProfessionalByIdUseCase;
import com.backendapiproject.searchandservice.usecase.GetServiceByIdUseCase;
import com.backendapiproject.searchandservice.usecase.ListProfessionalsUseCase;
import com.backendapiproject.searchandservice.usecase.UpdateProfessionalUseCase;
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
@RequestMapping("/v1/api/professional")
@RequiredArgsConstructor
public class ProfessionalController {

    private final CreateProfessionalUseCase createProfessionalUseCase;
    private final GetProfessionalByIdUseCase getProfessionalByIdUseCase;
    private final UpdateProfessionalUseCase updateProfessionalUseCase;
    private final DeleteProfessionalByIdUseCase deleteProfessionalByIdUseCase;
    private final ListProfessionalsUseCase listProfessionalsUseCase;
    private final AddServiceUseCase addServiceUseCase;
    private final ProfessionalMapper mapper;
    private final GetServiceByIdUseCase getServiceByIdUseCase;


    @PostMapping
    public ResponseEntity<Professional> saveProfessional(@RequestBody @Valid ProfessionalRequest request) {
        var savedProfessional = createProfessionalUseCase.execute(mapper.toProfessional(request));
        return new ResponseEntity<>(savedProfessional, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Professional> getProfessionalById(@PathVariable Long id) {
        var professional = getProfessionalByIdUseCase.execute(id);
        return new ResponseEntity<>(professional, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @Authorize(value = "ROLE_PROFESSIONAL")
    public ResponseEntity<Professional> updateProfessional(@PathVariable Long id, @Valid @RequestBody ProfessionalRequest request) {
        var updatedProfessional = updateProfessionalUseCase.execute(mapper.toProfessional(request), id);
        return new ResponseEntity<>(updatedProfessional, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Authorize(value = "ROLE_PROFESSIONAL")
    public ResponseEntity<Void> deleteProfessionalById(@PathVariable Long id) {
        deleteProfessionalByIdUseCase.execute(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<List<Professional>> getAllProfessionals() {
        var professionals = listProfessionalsUseCase.execute();
        return new ResponseEntity<>(professionals, HttpStatus.OK);
    }
    @PostMapping("/{professionalId}/service")
    @Authorize(value = "ROLE_PROFESSIONAL")
    public ResponseEntity<Professional> saveService(@PathVariable Long professionalId, @RequestBody Service service) {
        var professional = addServiceUseCase.execute(service, professionalId);
        return new ResponseEntity<>(professional, HttpStatus.CREATED);
    }

    /*
    @GetMapping("/{professionalId}/service/{serviceId}")
    public ResponseEntity<Service> getServiceById(@PathVariable Long professionalId, @PathVariable Long serviceId) {
        var  service = getServiceByIdUseCase.execute(serviceId);
        return new ResponseEntity<>(service, HttpStatus.OK);
    }

    @GetMapping("/{professionalId}/service}")
    public ResponseEntity<Service> getServiceAll(@PathVariable Long professionalId) {
        var  service = getServiceByIdUseCase.execute(serviceId);
        return new ResponseEntity<>(service, HttpStatus.OK);
    }
       */

}
