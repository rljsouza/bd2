package com.backendapiproject.searchandservice.infrastructure.config.main;

import com.backendapiproject.searchandservice.application.gateway.AppointmentGateWay;
import com.backendapiproject.searchandservice.application.usecaseImpl.AppointmentUseCaseImpl;
import com.backendapiproject.searchandservice.usecase.AppointmentUseCase;
import com.backendapiproject.searchandservice.usecase.GetCustomerByIdUseCase;
import com.backendapiproject.searchandservice.usecase.GetProfessionalByIdUseCase;
import com.backendapiproject.searchandservice.usecase.GetServiceByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppointmentMain {

    @Bean
    public AppointmentUseCase appointmentUseCase(AppointmentGateWay appointmentGateWay, GetCustomerByIdUseCase getCustomerByIdUseCase, GetServiceByIdUseCase getServiceByIdUseCase, GetProfessionalByIdUseCase getProfessionalByIdUseCase){
        return new AppointmentUseCaseImpl(appointmentGateWay, getCustomerByIdUseCase, getServiceByIdUseCase, getProfessionalByIdUseCase);
    }
}

