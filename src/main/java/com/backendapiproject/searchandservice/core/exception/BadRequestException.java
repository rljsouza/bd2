package com.backendapiproject.searchandservice.core.exception;

import org.springframework.http.HttpStatus;

public class BadRequestException extends BaseFullException {

    public BadRequestException(String message) {
        super(HttpStatus.BAD_REQUEST, message);
    }

    public BadRequestException(String field, String message) {
        super(HttpStatus.BAD_REQUEST, field, message);
    }

    public BadRequestException(String field, String message, String[] params) {
        super(HttpStatus.BAD_REQUEST, field, message, params);
    }

    public BadRequestException(String message, Throwable cause) {
        super(HttpStatus.BAD_REQUEST, message, cause);
    }


}
