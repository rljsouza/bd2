package com.backendapiproject.searchandservice.usecase;

interface AuthenticateClientUseCase {
    boolean authenticateClient(int clientId, String password);
}
