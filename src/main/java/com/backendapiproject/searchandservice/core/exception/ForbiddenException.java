package com.backendapiproject.searchandservice.core.exception;

import org.springframework.http.HttpStatus;

public class ForbiddenException extends BaseFullException {

    public ForbiddenException(String message) {
        super(HttpStatus.FORBIDDEN, message);
    }

    public ForbiddenException(String field, String message) {
        super(HttpStatus.FORBIDDEN, field, message);
    }

    public ForbiddenException(String field, String message, String[] params) {
        super(HttpStatus.FORBIDDEN, field, message, params);
    }

    public ForbiddenException(String message, Throwable cause) {
        super(HttpStatus.FORBIDDEN, message, cause);
    }

}
