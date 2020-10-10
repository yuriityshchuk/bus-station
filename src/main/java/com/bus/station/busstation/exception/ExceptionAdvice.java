package com.bus.station.busstation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionAdvice extends ResponseEntityExceptionHandler {


    @ExceptionHandler({CustomAuthenticationException.class})
    public ResponseEntity<?> handleAuthenticationException(CustomAuthenticationException e) {
        return buildResponseEntity(new ErrorModel(HttpStatus.FORBIDDEN, e));
    }

    @ExceptionHandler({DataNotFoundException.class})
    public ResponseEntity<?> dataNotFoundExceptionHandler(DataNotFoundException e) {
        return buildResponseEntity(new ErrorModel(HttpStatus.NOT_FOUND, e));
    }

    private ResponseEntity<?> buildResponseEntity(ErrorModel errorModel) {
        return new ResponseEntity<>(errorModel, errorModel.getStatus());
    }
}
