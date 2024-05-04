package com.backendapiproject.searchandservice.infrastructure.controller;

import com.backendapiproject.searchandservice.core.domain.Service;
import com.backendapiproject.searchandservice.infrastructure.annotation.Authorize;
import com.backendapiproject.searchandservice.infrastructure.dto.request.ServiceRequest;
import com.backendapiproject.searchandservice.infrastructure.mapper.ServiceMapper;
import com.backendapiproject.searchandservice.usecase.DeleteServiceByIdUseCase;
import com.backendapiproject.searchandservice.usecase.GetServiceByIdUseCase;
import com.backendapiproject.searchandservice.usecase.UpdateServiceUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/v1/api/service")
@RequiredArgsConstructor
public class ServiceController {

    private final GetServiceByIdUseCase getServiceByIdUseCase;
    private final DeleteServiceByIdUseCase deleteServiceByIdUseCase;
    //private final ListServiceUseCase listServiceUseCase;
    private final UpdateServiceUseCase updateServiceUseCase;
    private final ServiceMapper mapper;

    @GetMapping("/{id}")
    public ResponseEntity<Service> getServiceById(@PathVariable Long id) {
        var service = getServiceByIdUseCase.execute(id);
        return new ResponseEntity<>(service, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @Authorize(value = "ROLE_PROFESSIONAL")
    public ResponseEntity<Service> updateService(@PathVariable Long id,@Valid @RequestBody ServiceRequest request) {
        var updatedService = updateServiceUseCase.execute(mapper.toService(request), id);
        return new ResponseEntity<>(updatedService, HttpStatus.OK);
    }

}
