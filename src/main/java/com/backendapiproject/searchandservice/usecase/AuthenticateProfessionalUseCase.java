package com.backendapiproject.searchandservice.usecase;

interface AuthenticateProfessionalUseCase {
    boolean authenticateProfessional(int professionalId, String password);
}
