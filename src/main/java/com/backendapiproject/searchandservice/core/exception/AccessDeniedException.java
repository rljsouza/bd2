package com.backendapiproject.searchandservice.core.exception;

import org.springframework.http.HttpStatus;


public class AccessDeniedException extends BaseFullException {

    public AccessDeniedException(String message) {
        super(HttpStatus.FORBIDDEN, message);
    }

    public AccessDeniedException(String field, String message) {
        super(HttpStatus.FORBIDDEN, field, message);
    }

    public AccessDeniedException(String field, String message, String[] params) {
        super(HttpStatus.FORBIDDEN, field, message, params);
    }

    public AccessDeniedException(String message, Throwable cause) {
        super(HttpStatus.FORBIDDEN, message, cause);
    }

}
