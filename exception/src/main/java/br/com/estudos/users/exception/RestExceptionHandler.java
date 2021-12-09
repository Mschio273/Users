package br.com.estudos.users.exception;

import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.time.temporal.UnsupportedTemporalTypeException;

import static br.com.estudos.users.exception.ErrorConstants.*;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public StandardError handleResponseStatusException(ResponseStatusException e) {
        return StandardError.builder()
                        .status(e.getRawStatusCode())
                        .message(e.getMessage())
                        .build();
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(BAD_REQUEST)
    public StandardError handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        return StandardError.builder()
                .status(BAD_REQUEST.value())
                .message(USER_REQUIRED_TO_SAVE)
                .build();
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(INTERNAL_SERVER_ERROR)
    public StandardError handleGeneralExceptions(Exception e) {
        return StandardError.builder()
                .status(INTERNAL_SERVER_ERROR.value())
                .message(e.getMessage())
                .build();
    }


    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(INTERNAL_SERVER_ERROR)
    public StandardError handleRuntimeExceptions(RuntimeException e) {
        return StandardError.builder()
                .status(INTERNAL_SERVER_ERROR.value())
                .message(UNEXPECTED_ERROR)
                .build();
    }

    @ExceptionHandler(IOException.class)
    @ResponseStatus(INTERNAL_SERVER_ERROR)
    public StandardError handleIoExceptionExceptions(IOException e) {
        return StandardError.builder()
                .status(INTERNAL_SERVER_ERROR.value())
                .message(INPUT_OUTPUT_ERROR)
                .build();
    }

    @ExceptionHandler(UnsupportedTemporalTypeException.class)
    @ResponseStatus(BAD_REQUEST)
    public StandardError handleUnsupportedTemporalTypeException(UnsupportedTemporalTypeException e) {
        return StandardError.builder()
                .status(BAD_REQUEST.value())
                .message(USER_REQUIRED_TO_SAVE)
                .build();
    }
}