package com.backendapiproject.searchandservice.infrastructure.config;

import com.backendapiproject.searchandservice.core.domain.BusinessExceptionBody;
import com.backendapiproject.searchandservice.core.exception.BaseFullException;
import com.backendapiproject.searchandservice.core.exception.ExceptionResolver;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
@Slf4j
public class ControlExceptionHandler {

    public static final String X_RD_TRACEID = "X-traceid";
    public static final String CONSTRAINT_VALIDATION_FAILED = "Constraint validation failed";


    @ExceptionHandler(value = { BaseFullException.class})
    protected ResponseEntity<Object> handleConflict(BaseFullException ex, WebRequest request) {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set(X_RD_TRACEID,this.getTraceID());
        return ResponseEntity.status(ex.getStatus()).headers(responseHeaders).body(ex.getOnlyBody());

    }

    @ExceptionHandler({ Throwable.class })
    public ResponseEntity<Object> handleException(Throwable eThrowable) {

        BaseFullException ex = new BaseFullException(HttpStatus.INTERNAL_SERVER_ERROR, Optional.ofNullable(eThrowable.getMessage()).orElse(eThrowable.toString()));
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set(X_RD_TRACEID,this.getTraceID());
        return ResponseEntity.status(ex.getStatus()).headers(responseHeaders).body(ex.getOnlyBody());

    }

    @ExceptionHandler({ MethodArgumentTypeMismatchException.class })
    public ResponseEntity<Object> handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException exMethod, WebRequest request) {
        String error = exMethod.getName();
        Class<?> classData = exMethod.getRequiredType();
        if(classData != null){
            error += "deve ser: " + classData.getName();
        }
        BusinessExceptionBody ex = BusinessExceptionBody.builder()
                .code(HttpStatus.BAD_REQUEST.value())
                .httpStatusCode(HttpStatus.BAD_REQUEST)
                .message(CONSTRAINT_VALIDATION_FAILED)
                .description(Arrays.asList(error).toString())
                .build();
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set(X_RD_TRACEID,this.getTraceID());

        return ResponseEntity.status(ex.getHttpStatusCode()).headers(responseHeaders).body(ex);
    }


    @ExceptionHandler({ MissingRequestHeaderException.class })
    public ResponseEntity<Object> handleMissingRequestHeader(MissingRequestHeaderException exHeader) {
        String error = exHeader.getHeaderName() + ": o header deve ser informado";
        BusinessExceptionBody ex = BusinessExceptionBody.builder().httpStatusCode(HttpStatus.BAD_REQUEST)
                .code(HttpStatus.BAD_REQUEST.value())
                .message(CONSTRAINT_VALIDATION_FAILED)
                .description(Arrays.asList(error).toString())
                .build();
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set(X_RD_TRACEID, this.getTraceID());
        return ResponseEntity.status(ex.getHttpStatusCode()).headers(responseHeaders).body(ex);
    }


    @ExceptionHandler({ ConstraintViolationException.class })
    public ResponseEntity<Object> handleConstraintViolation(ConstraintViolationException exMethod, WebRequest request) {
        List<String> errors = new ArrayList<>();
        for (ConstraintViolation<?> violation : exMethod.getConstraintViolations()) {
            errors.add(violation.getPropertyPath() + ":" + violation.getMessage());
        }

        BusinessExceptionBody ex = BusinessExceptionBody.builder()
                .code(HttpStatus.BAD_REQUEST.value())
                .httpStatusCode(HttpStatus.BAD_REQUEST)
                .message(CONSTRAINT_VALIDATION_FAILED)
                .description(errors.toString())
                .build();
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set(X_RD_TRACEID,this.getTraceID());
        return ResponseEntity.status(ex.getHttpStatusCode()).headers(responseHeaders).body(ex);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> validationError(MethodArgumentNotValidException exMethod) {

        BindingResult bindingResult = exMethod.getBindingResult();

        List<FieldError> fieldErrors = bindingResult.getFieldErrors();

        List<String> fieldErrorDtos = fieldErrors.stream()
                .map(f -> f.getField().concat(": ").concat(f.getDefaultMessage())).map(String::new)
                .toList();

        BusinessExceptionBody ex = BusinessExceptionBody.builder()
                .code(HttpStatus.BAD_REQUEST.value())
                .httpStatusCode(HttpStatus.BAD_REQUEST)
                .message(CONSTRAINT_VALIDATION_FAILED)
                .description(fieldErrorDtos.toString())
                .build();
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set(X_RD_TRACEID,this.getTraceID());

        return ResponseEntity.status(ex.getHttpStatusCode()).headers(responseHeaders).body(ex);
    }


    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Object> validationError(HttpMessageNotReadableException exMethod) {

        Throwable mostSpecificCause = exMethod.getMostSpecificCause();
        BusinessExceptionBody ex = BusinessExceptionBody.builder()
                .code(HttpStatus.BAD_REQUEST.value())
                .httpStatusCode(HttpStatus.BAD_REQUEST)
                .message(CONSTRAINT_VALIDATION_FAILED)
                .description(mostSpecificCause.getMessage())
                .build();
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set(X_RD_TRACEID,this.getTraceID());
        return ResponseEntity.status(ex.getHttpStatusCode()).headers(responseHeaders).body(ex);
    }

    @ExceptionHandler({ MissingServletRequestParameterException.class })
    public ResponseEntity<Object> handleException(MissingServletRequestParameterException e) {

        BusinessExceptionBody ex = BusinessExceptionBody.builder()
                .code(HttpStatus.BAD_REQUEST.value())
                .httpStatusCode(HttpStatus.BAD_REQUEST)
                .message(Optional.ofNullable(e.getMessage()).orElse(e.toString()))
                .description(ExceptionResolver.getRootException(e))
                .build();
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set(X_RD_TRACEID,this.getTraceID());
        return ResponseEntity.status(ex.getHttpStatusCode()).headers(responseHeaders).body(ex);
    }

    @ExceptionHandler({ HttpRequestMethodNotSupportedException.class })
    public ResponseEntity<Object> handleException(HttpRequestMethodNotSupportedException  e) {

        BusinessExceptionBody ex = BusinessExceptionBody.builder()
                .code(HttpStatus.METHOD_NOT_ALLOWED.value())
                .httpStatusCode(HttpStatus.METHOD_NOT_ALLOWED)
                .message(Optional.ofNullable(e.getMessage()).orElse(e.toString()))
                .description(ExceptionResolver.getRootException(e))
                .build();
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set(X_RD_TRACEID,this.getTraceID());
        return ResponseEntity.status(ex.getHttpStatusCode()).headers(responseHeaders).body(ex);
    }


    @ExceptionHandler({ BindException.class })
    public ResponseEntity<Object> handleException(BindException ex, HttpServletResponse response) {
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        List<String> errors = new ArrayList<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.add(error.getField() + ": " + error.getDefaultMessage());
        }
        for (ObjectError error : ex.getBindingResult().getGlobalErrors()) {
            errors.add(error.getObjectName() + ": " + error.getDefaultMessage());
        }
        errors.toString();
        BusinessExceptionBody bex = BusinessExceptionBody.builder()
                .code(HttpStatus.BAD_REQUEST.value())
                .httpStatusCode(HttpStatus.BAD_REQUEST)
                .message(errors.toString())
                .build();
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set(X_RD_TRACEID, this.getTraceID());
        return ResponseEntity.status(bex.getHttpStatusCode()).headers(responseHeaders).body(bex);

    }

    private String getTraceID() {
        return "";
    }


}
