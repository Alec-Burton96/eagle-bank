package com.barclays.eagle.exception;

import com.barclays.eagle.controller.AccountController;
import com.barclays.eagle.controller.TransactionController;
import com.barclays.eagle.model.DefaultInternalErrorResponse;
import com.barclays.eagle.model.user.responseDTO.VerboseBadRequestResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.NoSuchElementException;


@RestControllerAdvice(assignableTypes = TransactionController.class)
public class TransactionsExceptionHandler {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<DefaultInternalErrorResponse> notFoundException() {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND.value())
                .body(new DefaultInternalErrorResponse("Record not found"));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<VerboseBadRequestResponse> necessaryDataNotSuppliedException() {
        return ResponseEntity
                .status(400)
                .body(new VerboseBadRequestResponse("necessary data not supplied", List.of(
                        new VerboseBadRequestResponse.Details(
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
