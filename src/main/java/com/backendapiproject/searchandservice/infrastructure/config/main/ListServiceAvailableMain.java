package com.backendapiproject.searchandservice.infrastructure.config.main;


import com.backendapiproject.searchandservice.application.usecaseImpl.ListServiceAvailableUseCaseImpl;
import com.backendapiproject.searchandservice.usecase.AppointmentUseCase;
import com.backendapiproject.searchandservice.usecase.GetProfessionalByIdUseCase;
import com.backendapiproject.searchandservice.usecase.ListServiceAvailableUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ListServiceAvailableMain {

    @Bean
    public ListServiceAvailableUseCase listServiceAvailableUseCase(GetProfessionalByIdUseCase getProfessionalByIdUseCase, AppointmentUseCase appointmentUseCase){
        return new ListServiceAvailableUseCaseImpl(getProfessionalByIdUseCase,appointmentUseCase);
    }
}
