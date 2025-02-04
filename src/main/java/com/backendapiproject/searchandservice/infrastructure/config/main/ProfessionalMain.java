package com.backendapiproject.searchandservice.infrastructure.config.main;


import com.backendapiproject.searchandservice.application.gateway.ProfessionalGateway;
import com.backendapiproject.searchandservice.application.gateway.ServiceGateway;
import com.backendapiproject.searchandservice.application.usecaseImpl.AddServiceUseCaseImpl;
import com.backendapiproject.searchandservice.application.usecaseImpl.CreateProfessionalUseCaseImpl;
import com.backendapiproject.searchandservice.application.usecaseImpl.DeleteProfessionalByIdUseCaseImpl;
import com.backendapiproject.searchandservice.application.usecaseImpl.GetProfessionalByIdUseCaseImpl;
import com.backendapiproject.searchandservice.application.usecaseImpl.GetServiceByProfessionalIdUseCaseImpl;
import com.backendapiproject.searchandservice.application.usecaseImpl.ListProfessionalsUseCaseImpl;
import com.backendapiproject.searchandservice.application.usecaseImpl.UpdateProfessionalUseCaseImpl;
import com.backendapiproject.searchandservice.usecase.AddServiceUseCase;
import com.backendapiproject.searchandservice.usecase.BusinessHoursUseCase;
import com.backendapiproject.searchandservice.usecase.CreateAddressUseCase;
import com.backendapiproject.searchandservice.usecase.CreateProfessionalUseCase;
import com.backendapiproject.searchandservice.usecase.DeleteProfessionalByIdUseCase;
import com.backendapiproject.searchandservice.usecase.GetProfessionalByIdUseCase;
import com.backendapiproject.searchandservice.usecase.GetRoleByRoleType;
import com.backendapiproject.searchandservice.usecase.GetServiceByProfessionalIdUseCase;
import com.backendapiproject.searchandservice.usecase.ListProfessionalsUseCase;
import com.backendapiproject.searchandservice.usecase.UpdateAddressUseCase;
import com.backendapiproject.searchandservice.usecase.UpdateProfessionalUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProfessionalMain {

    @Bean
    public CreateProfessionalUseCase createProfessionalUseCase(ProfessionalGateway professionalGateway, CreateAddressUseCase createAddressUseCase, GetRoleByRoleType getRoleByRoleType){
        return new CreateProfessionalUseCaseImpl(professionalGateway, createAddressUseCase, getRoleByRoleType);
    }

    @Bean
    public GetProfessionalByIdUseCase getProfessionalByIdUseCase(ProfessionalGateway professionalGateway){
        return new GetProfessionalByIdUseCaseImpl(professionalGateway);
    }

    @Bean
    public UpdateProfessionalUseCase updateProfessionalUseCase(ProfessionalGateway professionalGateway, GetProfessionalByIdUseCase getProfessionalById, UpdateAddressUseCase updateAddressUseCase){
        return new UpdateProfessionalUseCaseImpl(professionalGateway, getProfessionalById, updateAddressUseCase);
    }

    @Bean
    public DeleteProfessionalByIdUseCase deleteProfessionalByIdUseCase(ProfessionalGateway professionalGateway, GetProfessionalByIdUseCase getProfessionalById){
        return new DeleteProfessionalByIdUseCaseImpl(professionalGateway, getProfessionalById);
    }

    @Bean
    public ListProfessionalsUseCase listProfessionalsUseCase(ProfessionalGateway professionalGateway){
        return new ListProfessionalsUseCaseImpl(professionalGateway);
    }
    @Bean
    public AddServiceUseCase addServiceUseCase(ServiceGateway serviceGateway, GetProfessionalByIdUseCase getProfessionalById, UpdateProfessionalUseCase updateProfessionalUseCase, BusinessHoursUseCase businessHoursUseCase){
        return new AddServiceUseCaseImpl(serviceGateway, getProfessionalById, updateProfessionalUseCase, businessHoursUseCase);
    }

    @Bean
    public GetServiceByProfessionalIdUseCase getServiceByProfessionalIdUseCase(ProfessionalGateway professionalGateway, GetProfessionalByIdUseCase getProfessionalByIdUseCase){
         return new GetServiceByProfessionalIdUseCaseImpl(professionalGateway, getProfessionalByIdUseCase );
    }
}
