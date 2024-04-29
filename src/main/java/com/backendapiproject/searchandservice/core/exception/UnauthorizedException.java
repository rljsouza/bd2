package com.backendapiproject.searchandservice.core.exception;

import org.springframework.http.HttpStatus;


public class UnauthorizedException extends BaseFullException {

    public UnauthorizedException(String message) {
        super(HttpStatus.UNAUTHORIZED, message);
    }

    public UnauthorizedException(String field, String message) {
        super(HttpStatus.UNAUTHORIZED, field, message);
    }

    public UnauthorizedException(String field, String message, String[] params) {
        super(HttpStatus.UNAUTHORIZED, field, message, params);
    }

    public UnauthorizedException(String message, Throwable cause) {
        super(HttpStatus.UNAUTHORIZED, message, cause);
    }

    public UnauthorizedException(Throwable cause) {
        super(HttpStatus.UNAUTHORIZED, cause);
    }
}
