package com.backendapiproject.searchandservice.infrastructure.controller;

import com.backendapiproject.searchandservice.core.domain.ServiceAvailability;
import com.backendapiproject.searchandservice.infrastructure.annotation.Authorize;
import com.backendapiproject.searchandservice.infrastructure.dto.AvailabilityDTO;
import com.backendapiproject.searchandservice.infrastructure.dto.enums.DayOfWeek;
import com.backendapiproject.searchandservice.infrastructure.dto.request.ProfessionalRequest;
import com.backendapiproject.searchandservice.infrastructure.dto.request.ServiceRequest;
import com.backendapiproject.searchandservice.infrastructure.dto.response.ProfessionalResponse;
import com.backendapiproject.searchandservice.infrastructure.dto.response.ServiceResponse;
import com.backendapiproject.searchandservice.infrastructure.mapper.ProfessionalMapper;
import com.backendapiproject.searchandservice.infrastructure.mapper.ServiceMapper;
import com.backendapiproject.searchandservice.infrastructure.repository.ProfessionalReviewRepository;
import com.backendapiproject.searchandservice.usecase.AddServiceUseCase;
import com.backendapiproject.searchandservice.usecase.CreateProfessionalUseCase;
import com.backendapiproject.searchandservice.usecase.DeleteProfessionalByIdUseCase;
import com.backendapiproject.searchandservice.usecase.DeleteServiceByIdUseCase;
import com.backendapiproject.searchandservice.usecase.GetProfessionalByIdUseCase;
import com.backendapiproject.searchandservice.usecase.GetServiceByProfessionalIdUseCase;
import com.backendapiproject.searchandservice.usecase.ListProfessionalsUseCase;
import com.backendapiproject.searchandservice.usecase.ListServiceAvailableUseCase;
import com.backendapiproject.searchandservice.usecase.UpdateProfessionalUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;
import java.util.Date;
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
    private final ServiceMapper serviceMapper;
    private final GetServiceByProfessionalIdUseCase getServiceByProfessionalIdUseCase;
    private final DeleteServiceByIdUseCase deleteServiceByIdUseCase;
    private final ListServiceAvailableUseCase listServiceAvailableUseCase;
    private final ProfessionalReviewRepository professionalReviewRepository;



    @PostMapping
    public ResponseEntity<ProfessionalResponse> saveProfessional(@RequestBody @Valid ProfessionalRequest request) {
        var savedProfessional = createProfessionalUseCase.execute(mapper.toProfessional(request));
        return new ResponseEntity<>(mapper.toProfessionalResponse(savedProfessional), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfessionalResponse> getProfessionalById(@PathVariable Long id) {
        var professional = getProfessionalByIdUseCase.execute(id);
        return new ResponseEntity<>(mapper.toProfessionalResponse(professional), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @Authorize(value = "ROLE_PROFESSIONAL")
    public ResponseEntity<ProfessionalResponse> updateProfessional(@PathVariable Long id, @Valid @RequestBody ProfessionalRequest request) {
        var updatedProfessional = updateProfessionalUseCase.execute(mapper.toProfessional(request), id);
        return new ResponseEntity<>(mapper.toProfessionalResponse(updatedProfessional), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Authorize(value = "ROLE_PROFESSIONAL")
    public ResponseEntity<Void> deleteProfessionalById(@PathVariable Long id) {
        deleteProfessionalByIdUseCase.execute(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/trigger/{id}")
    // @Authorize(value = "ROLE_PROFESSIONAL")
    public ResponseEntity<Void> deleteProfessionalTriggerById(@PathVariable Long id) {
        professionalReviewRepository.deleteCustomerById(id.intValue());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<List<ProfessionalResponse>> getAllProfessionals() {
        var professionals = listProfessionalsUseCase.execute();
        return new ResponseEntity<>(mapper.toProfessionalResponse(professionals), HttpStatus.OK);
    }

    @PostMapping("/{professionalId}/service")
  //  @Authorize(value = "ROLE_PROFESSIONAL")
    public ResponseEntity<ProfessionalResponse> saveService(@PathVariable Long professionalId, @RequestBody @Valid ServiceRequest request) {
        var professional = addServiceUseCase.execute(serviceMapper.toService(request), professionalId);
        return new ResponseEntity<>(mapper.toProfessionalResponse(professional), HttpStatus.CREATED);
    }


    @GetMapping("/{professionalId}/service")
    public ResponseEntity<List<ServiceResponse>> getAllService(@PathVariable Long professionalId) {
        var service = getServiceByProfessionalIdUseCase.execute(professionalId);
        return new ResponseEntity<>(serviceMapper.toServiceResponse(service), HttpStatus.OK);
    }

    @GetMapping("/{professionalId}/service/{serviceId}/available")
    public ResponseEntity<List<ServiceAvailability>> listServiceAvailable(@PathVariable Long professionalId, @PathVariable Long serviceId) {
        var serviceAvailabilities = listServiceAvailableUseCase.execute(professionalId, serviceId);
        return new ResponseEntity<>(serviceAvailabilities, HttpStatus.OK);
    }

    @DeleteMapping("/{professionalId}/service/{serviceId}")
    @Authorize(value = "ROLE_PROFESSIONAL")
    public ResponseEntity<Void> deleteServiceById(@PathVariable Long professionalId, @PathVariable Long serviceId) {
        deleteServiceByIdUseCase.execute(professionalId, serviceId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{professionalId}/service/{serviceId}/checkAvailabilityByDate")
    public ResponseEntity<List<AvailabilityDTO>> checkAvailability(
            @PathVariable("professionalId") Integer professionalId,
            @PathVariable("serviceId") Integer serviceId,
            @RequestHeader("appointmentDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date appointmentDate) {

        return new ResponseEntity<>(professionalReviewRepository.checkAvailability(professionalId, serviceId, appointmentDate), HttpStatus.OK);

    }

    @GetMapping("/{professionalId}/service/{serviceId}/calculateDuration")
    public ResponseEntity<Integer> calculateServiceDuration(
            @PathVariable("serviceId") Integer serviceId,
            @PathVariable("professionalId") Integer professionalId) {

        Integer duration = professionalReviewRepository.calculateServiceDuration(serviceId, professionalId);
        return new ResponseEntity<>(duration, HttpStatus.OK);
    }

    @GetMapping("/allAvailable")
    public ResponseEntity<List<AvailabilityDTO>> calculateServiceDuration(@RequestHeader("dayOfWeek") DayOfWeek dayOfWeek,   @RequestHeader("startTime")LocalTime startTime, @RequestHeader("endTime") LocalTime endTime) {
        var availabilityDTO = professionalReviewRepository.getAvailableProfessionals(dayOfWeek, startTime, endTime);
        return new ResponseEntity<>(availabilityDTO, HttpStatus.OK);
    }


}

