package com.backendapiproject.searchandservice.usecase;

interface AuthenticateClientUseCase {
    boolean execute(Long clientId, String password);
}
