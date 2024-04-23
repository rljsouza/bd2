package com.backendapiproject.searchandservice.usecase;

public interface AuthenticateClientUseCase {
    boolean execute(Long clientId, String password);
}
