package com.backendapiproject.searchandservice.core.exception;


import org.springframework.http.HttpStatus;

public class BaseFullException extends RuntimeException {

    private static final long serialVersionUID = -8620996109869261307L;

    private final HttpStatus status;
    private final String field;
    private final String[] params;

    public BaseFullException(HttpStatus status, String message) {
        super(message);
        this.status = status;
        this.field = null;
        this.params = null;
    }

    public BaseFullException(HttpStatus status, String field, String message) {
        super(message);
        this.status = status;
        this.field = field;
        this.params = null;
    }

    public BaseFullException(HttpStatus status, String field, String message, String[] params) {
        super(message);
        this.status = status;
        this.field = field;
        this.params = params;
    }

    public BaseFullException(HttpStatus status, String message, Throwable cause) {
        super(message, cause);
        this.status = status;
        this.field = null;
        this.params = null;
    }

    public BaseFullException(HttpStatus status, String field, String message, Throwable cause) {
        super(message, cause);
        this.status = status;
        this.field = field;
        this.params = null;
    }
    public BaseFullException(HttpStatus status, Throwable cause) {
        super(cause.getMessage(), cause);
        this.status = status;
        this.field = null;
        this.params = null;
    }

    public BaseFullException(HttpStatus status, String field, String message, String[] params, Throwable cause) {
        super(message, cause);
        this.status = status;
        this.field = field;
        this.params = params;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getField() {
        return field;
    }

    public String[] getParams() {
        return params;
    }
}
