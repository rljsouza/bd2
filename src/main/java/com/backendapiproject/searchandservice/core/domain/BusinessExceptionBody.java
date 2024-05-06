package com.backendapiproject.searchandservice.core.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder(toBuilder = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
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
    private HttpStatus httpStatusCode;

    public BusinessExceptionBody(int code, String message, String field, String[] params, String description, String origin, String error, String errorDescription, HttpStatus httpStatusCode) {
        this.code = code;
        this.message = message;
        this.field = field;
        this.params = params;
        this.description = description;
        this.origin = origin;
        this.error = error;
        this.errorDescription = errorDescription;
        this.httpStatusCode = httpStatusCode;
    }


}
