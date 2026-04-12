package com.barclays.eagle.exception;

import com.barclays.eagle.model.DefaultInternalErrorResponse;
import com.barclays.eagle.model.user.responseDTO.FetchUserBadRequestResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.HandlerMethodValidationException;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;


@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleValidationException() {
        return ResponseEntity
                .badRequest()
                .body(HttpStatus.BAD_REQUEST.getReasonPhrase());
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<DefaultInternalErrorResponse> notFoundException() {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND.value())
                .body(new DefaultInternalErrorResponse("Record not found"));
    }

    @ExceptionHandler(HandlerMethodValidationException.class)
    public ResponseEntity<FetchUserBadRequestResponse> necessaryDataNotSuppliedException() {
        return ResponseEntity
                .status(400)
                .body(new FetchUserBadRequestResponse("necessary data not supplied", List.of(
                        new FetchUserBadRequestResponse.Details(
                                "id",
                                "invalid id",
                                "String"))));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<DefaultInternalErrorResponse> defaultException() {
        return ResponseEntity
                .internalServerError()
                .body(new DefaultInternalErrorResponse("An error has occurred."));
    }
}
