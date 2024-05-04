package com.backendapiproject.searchandservice.infrastructure.config;

import com.backendapiproject.searchandservice.core.exception.BaseFullException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import java.util.Optional;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
@Slf4j
public class ControlExceptionHandler {

    public static final String X_RD_TRACEID = "X-traceid";

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
      //  log.info(ConstantsLog.LOG_KEY_METHOD + ConstantsLog.LOG_KEY_EVENT + ConstantsLog.LOG_KEY_CAUSE,  "handleException" , ConstantsLog.LOG_EVENT_INFO, ExceptionResolver.getRootException(ex));
        return ResponseEntity.status(ex.getStatus()).headers(responseHeaders).body(ex.getOnlyBody());

    }
    /*
    @ExceptionHandler({ MethodArgumentTypeMismatchException.class })
    public ResponseEntity<Object> handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException exMethod, WebRequest request) {
        String error = exMethod.getName();
        Class<?> classData = exMethod.getRequiredType();
        if(classData != null){
            error += "deve ser: " + classData.getName();
        }
        BusinessException ex = BusinessException.builder()
                .httpStatusCode(HttpStatus.BAD_REQUEST)
                .message(CONSTRAINT_VALIDATION_FAILED)
                .description(Arrays.asList(error).toString())
                .build();
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set(X_RD_TRACEID,this.getTraceID());
        log.info(ConstantsLog.LOG_KEY_METHOD + ConstantsLog.LOG_KEY_EVENT + ConstantsLog.LOG_KEY_CAUSE,  "handleMethodArgumentTypeMismatch" , ConstantsLog.LOG_EVENT_INFO, ExceptionResolver.getRootException(ex));

        return ResponseEntity.status(ex.getHttpStatusCode()).headers(responseHeaders).body(ex.getOnlyBody());
    }


    @ExceptionHandler({ MissingRequestHeaderException.class })
    public ResponseEntity<Object> handleMissingRequestHeader(MissingRequestHeaderException exHeader) {
        String error = exHeader.getHeaderName() + ":o header deve ser informado";
        BusinessException ex = BusinessException.builder().httpStatusCode(HttpStatus.BAD_REQUEST)
                .message(CONSTRAINT_VALIDATION_FAILED)
                .description(Arrays.asList(error).toString())
                .build();
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set(X_RD_TRACEID, this.getTraceID());
        log.info(ConstantsLog.LOG_KEY_METHOD + ConstantsLog.LOG_KEY_EVENT + ConstantsLog.LOG_KEY_CAUSE,  "handleMissingRequestHeader" , ConstantsLog.LOG_EVENT_INFO, ExceptionResolver.getRootException(ex));
        return ResponseEntity.status(ex.getHttpStatusCode()).headers(responseHeaders).body(ex.getOnlyBody());
    }


    @ExceptionHandler({ ConstraintViolationException.class })
    public ResponseEntity<Object> handleConstraintViolation(ConstraintViolationException exMethod, WebRequest request) {
        List<String> errors = new ArrayList<>();
        for (ConstraintViolation<?> violation : exMethod.getConstraintViolations()) {
            errors.add(violation.getPropertyPath() + ":" + violation.getMessage());
        }

        BusinessException ex = BusinessException.builder()
                .httpStatusCode(HttpStatus.BAD_REQUEST)
                .message(CONSTRAINT_VALIDATION_FAILED)
                .description(errors.toString())
                .build();
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set(X_RD_TRACEID,this.getTraceID());
        log.info(ConstantsLog.LOG_KEY_METHOD + ConstantsLog.LOG_KEY_EVENT + ConstantsLog.LOG_KEY_CAUSE,  "handleConstraintViolation" , ConstantsLog.LOG_EVENT_INFO, ExceptionResolver.getRootException(ex));

        return ResponseEntity.status(ex.getHttpStatusCode()).headers(responseHeaders).body(ex.getOnlyBody());
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> validationError(MethodArgumentNotValidException exMethod) {

        BindingResult bindingResult = exMethod.getBindingResult();

        List<FieldError> fieldErrors = bindingResult.getFieldErrors();

        List<String> fieldErrorDtos = fieldErrors.stream()
                .map(f -> f.getField().concat(":").concat(f.getDefaultMessage())).map(String::new)
                .toList();

        BusinessException ex = BusinessException.builder()
                .httpStatusCode(HttpStatus.BAD_REQUEST)
                .message(CONSTRAINT_VALIDATION_FAILED)
                .origin(Constants.ORIGIN_MS_SEARCH_OFFER_COMPOSITION)
                .description(fieldErrorDtos.toString())
                .build();
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set(X_RD_TRACEID,this.getTraceID());
        log.info(ConstantsLog.LOG_KEY_METHOD + ConstantsLog.LOG_KEY_EVENT + ConstantsLog.LOG_KEY_CAUSE,  "validationError" , ConstantsLog.LOG_EVENT_INFO, ExceptionResolver.getRootException(ex));

        return ResponseEntity.status(ex.getHttpStatusCode()).headers(responseHeaders).body(ex.getOnlyBody());
    }


    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Object> validationError(HttpMessageNotReadableException exMethod) {

        Throwable mostSpecificCause = exMethod.getMostSpecificCause();
        BusinessException ex = BusinessException.builder()
                .httpStatusCode(HttpStatus.BAD_REQUEST)
                .message(CONSTRAINT_VALIDATION_FAILED)
                .description(mostSpecificCause.getMessage())
                .build();
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set(X_RD_TRACEID,this.getTraceID());
        log.info(ConstantsLog.LOG_KEY_METHOD + ConstantsLog.LOG_KEY_EVENT + ConstantsLog.LOG_KEY_CAUSE,  "validationError" , ConstantsLog.LOG_EVENT_INFO, ExceptionResolver.getRootException(ex));

        return ResponseEntity.status(ex.getHttpStatusCode()).headers(responseHeaders).body(ex.getOnlyBody());
    }

    @ExceptionHandler({ MissingServletRequestParameterException.class })
    public ResponseEntity<Object> handleException(MissingServletRequestParameterException e) {

        BusinessException ex = BusinessException.builder()
                .httpStatusCode(HttpStatus.BAD_REQUEST)
                .message(Optional.ofNullable(e.getMessage()).orElse(e.toString()))
                .description(ExceptionResolver.getRootException(e))
                .build();
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set(X_RD_TRACEID,this.getTraceID());
        log.info(ConstantsLog.LOG_KEY_METHOD + ConstantsLog.LOG_KEY_EVENT + ConstantsLog.LOG_KEY_CAUSE,  "handleException" , ConstantsLog.LOG_EVENT_INFO, ExceptionResolver.getRootException(e));

        return ResponseEntity.status(ex.getHttpStatusCode()).headers(responseHeaders).body(ex.getOnlyBody());
    }

    @ExceptionHandler({ HttpRequestMethodNotSupportedException.class })
    public ResponseEntity<Object> handleException(HttpRequestMethodNotSupportedException  e) {

        BusinessException ex = BusinessException.builder()
                .httpStatusCode(HttpStatus.METHOD_NOT_ALLOWED)
                .message(Optional.ofNullable(e.getMessage()).orElse(e.toString()))
                .description(ExceptionResolver.getRootException(e))
                .build();
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set(X_RD_TRACEID,this.getTraceID());
        log.info(ConstantsLog.LOG_KEY_METHOD + ConstantsLog.LOG_KEY_EVENT + ConstantsLog.LOG_KEY_CAUSE,  "handleException" , ConstantsLog.LOG_EVENT_INFO, ExceptionResolver.getRootException(e));

        return ResponseEntity.status(ex.getHttpStatusCode()).headers(responseHeaders).body(ex.getOnlyBody());
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
        BusinessException bex = BusinessException.builder()
                .httpStatusCode(HttpStatus.BAD_REQUEST)
                .message(errors.toString())
                .build();
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set(X_RD_TRACEID,this.getTraceID());
        log.info(ConstantsLog.LOG_KEY_METHOD + ConstantsLog.LOG_KEY_EVENT + ConstantsLog.LOG_KEY_CAUSE,  "handleException" , ConstantsLog.LOG_EVENT_INFO, ExceptionResolver.getRootException(ex));
        return ResponseEntity.status(bex.getHttpStatusCode()).headers(responseHeaders).body(bex.getOnlyBody());

    }

    @ExceptionHandler(FeignException.BadRequest.class)
    public ResponseEntity<Object> handleFeignStatusException(FeignException e, HttpServletResponse response) {
        response.setStatus(e.status());
        e.contentUTF8();
        BusinessException ex = BusinessException.builder()
                .httpStatusCode(HttpStatus.BAD_REQUEST)
                .message(Optional.ofNullable(e.getMessage()).orElse(e.toString()))
                .description(ExceptionResolver.getRootException(e))
                .build();
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set(X_RD_TRACEID,this.getTraceID());
        log.info(ConstantsLog.LOG_KEY_METHOD + ConstantsLog.LOG_KEY_EVENT + ConstantsLog.LOG_KEY_CAUSE,  "handleFeignStatusException" , ConstantsLog.LOG_EVENT_INFO, ExceptionResolver.getRootException(ex));
        return ResponseEntity.status(ex.getHttpStatusCode()).headers(responseHeaders).body(ex.getOnlyBody());
    }

    @ExceptionHandler(FeignException.class)
    public ResponseEntity<Object> handleFeignsException(FeignException e, HttpServletResponse response) {
        response.setStatus(e.status());
        e.contentUTF8();
        BusinessException ex = BusinessException.builder()
                .httpStatusCode(HttpStatus.valueOf(e.status()))
                .message(Optional.ofNullable(e.getMessage()).orElse(e.toString()))
                .description(ExceptionResolver.getRootException(e))
                .build();
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set(X_RD_TRACEID,this.getTraceID());
        log.info(ConstantsLog.LOG_KEY_METHOD + ConstantsLog.LOG_KEY_EVENT + ConstantsLog.LOG_KEY_CAUSE,  "handleFeignsException" , ConstantsLog.LOG_EVENT_INFO, ExceptionResolver.getRootException(ex));
        return ResponseEntity.status(ex.getHttpStatusCode()).headers(responseHeaders).body(ex.getOnlyBody());
    }
   */

    private String getTraceID() {
        return "";
    }


}
