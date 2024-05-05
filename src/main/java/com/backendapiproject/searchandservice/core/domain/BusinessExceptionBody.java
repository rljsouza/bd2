package com.backendapiproject.searchandservice.core.domain;

public class BusinessExceptionBody {
    private int code;
    private String httpStatus;
    private String message;
    private String field;
    private String[] params;
    private String description;
    private String origin;
    private String error;
    private String errorDescription;

    public BusinessExceptionBody(int code, String message, String field, String[] params, String description, String origin, String error, String errorDescription) {
        this.code = code;
        this.message = message;
        this.field = field;
        this.params = params;
        this.description = description;
        this.origin = origin;
        this.error = error;
        this.errorDescription = errorDescription;
    }

    // Getters and setters for BusinessExceptionBody fields
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String[] getParams() {
        return params;
    }

    public void setParams(String[] params) {
        this.params = params;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }
}
