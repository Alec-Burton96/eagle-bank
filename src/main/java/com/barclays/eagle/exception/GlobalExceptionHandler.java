package com.barclays.eagle.exception;

import com.barclays.eagle.model.DefaultInternalErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleValidationException() {
        return ResponseEntity
                .badRequest()
                .body(HttpStatus.BAD_REQUEST.getReasonPhrase());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<DefaultInternalErrorResponse> defaultException() {
        return ResponseEntity
                .internalServerError()
                .body(new DefaultInternalErrorResponse("An error has occurred."));
    }
}
