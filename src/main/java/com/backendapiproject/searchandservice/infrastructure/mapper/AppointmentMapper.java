package com.backendapiproject.searchandservice.infrastructure.mapper;

import com.backendapiproject.searchandservice.core.domain.Appointment;
import com.backendapiproject.searchandservice.infrastructure.dto.request.AppointmentRequest;
import com.backendapiproject.searchandservice.infrastructure.entity.AppointmentEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AppointmentMapper {

    private final ModelMapper mapper;


    public Appointment toAppointment(AppointmentEntity appointment){
        return mapper.map(appointment, Appointment.class);
    }

    public Appointment toAppointment(AppointmentRequest request){
        return mapper.map(request, Appointment.class);
    }

    public AppointmentEntity toAppointment(Appointment appointment){
        return mapper.map(appointment, AppointmentEntity.class);
    }

    public List<Appointment> toAppointment(List<AppointmentEntity> appointment){
        return appointment.stream().map(this::toAppointment).collect(Collectors.toList());
    }

}
