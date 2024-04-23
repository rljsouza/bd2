package com.backendapiproject.searchandservice.usecase;

public interface AuthenticateProfessionalUseCase {
    boolean execute(Long professionalId, String password);
}
