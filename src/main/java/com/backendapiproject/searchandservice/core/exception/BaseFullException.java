package com.backendapiproject.searchandservice.core.exception;

import com.backendapiproject.searchandservice.core.domain.BusinessExceptionBody;
import org.springframework.http.HttpStatus;

public class BaseFullException extends RuntimeException {

    private static final long serialVersionUID = -8620996109869261307L;

    private final HttpStatus status;
    private final String field;
    private final String[] params;
    private final String description;
    private final String origin;
    private final String error;
    private final String errorDescription;

    public BaseFullException(HttpStatus status, String message) {
        this(status, null, message, null, null, null, null, null);
    }

    public BaseFullException(HttpStatus status, String field, String message) {
        this(status, field, message, null, null, null, null, null);
    }

    public BaseFullException(HttpStatus status, String field, String message, String[] params) {
        this(status, field, message, params, null, null, null, null);
    }

    public BaseFullException(HttpStatus status, String message, Throwable cause) {
        this(status, null, message, null, null, null, null, cause.getMessage());
    }

    public BaseFullException(HttpStatus status, String field, String message, Throwable cause) {
        this(status, field, message, null, null, null, null, cause.getMessage());
    }

    public BaseFullException(HttpStatus status, String field, String message, String[] params, Throwable cause) {
        this(status, field, message, params, null, null, null, cause.getMessage());
    }

    public BaseFullException(HttpStatus status, String field, String message, String[] params, String description, String origin, String error, String errorDescription) {
        super(message);
        this.status = status;
        this.field = field;
        this.params = params;
        this.description = description;
        this.origin = origin;
        this.error = error;
        this.errorDescription = errorDescription;
    }

    public BusinessExceptionBody getOnlyBody() {
        return new BusinessExceptionBody(
                this.status.value(),
                this.getMessage(),
                this.field,
                this.params,
                this.description,
                this.origin,
                this.error,
                this.errorDescription
        );
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

    public String getDescription() {
        return description;
    }

    public String getOrigin() {
        return origin;
    }

    public String getError() {
        return error;
    }

    public String getErrorDescription() {
        return errorDescription;
    }
}
