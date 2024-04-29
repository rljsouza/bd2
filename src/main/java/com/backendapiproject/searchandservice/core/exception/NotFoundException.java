package com.backendapiproject.searchandservice.core.exception;


import org.springframework.http.HttpStatus;

public class NotFoundException extends BaseFullException {

    public NotFoundException(String message) {
        super(HttpStatus.NOT_FOUND, message);
    }

    public NotFoundException(String field, String message) {
        super(HttpStatus.NOT_FOUND, field, message);
    }

    public NotFoundException(String field, String message, String[] params) {
        super(HttpStatus.NOT_FOUND, field, message, params);
    }

    public NotFoundException(String message, Throwable cause) {
        super(HttpStatus.NOT_FOUND, message, cause);
    }

    public NotFoundException(Throwable cause) {
        super(HttpStatus.NOT_FOUND, cause);
    }
}
