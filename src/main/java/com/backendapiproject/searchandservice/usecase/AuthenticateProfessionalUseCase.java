package com.backendapiproject.searchandservice.usecase;

interface AuthenticateProfessionalUseCase {
    boolean execute(Long professionalId, String password);
}
