package com.adolfo.test.gs.incomes.exception;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

@RestControllerAdvice
public class HandlerException {
    @ExceptionHandler(value = { Exception.class, IllegalArgumentException.class, ClassNotFoundException.class,
            IllegalStateException.class, RuntimeException.class,
            NullPointerException.class })
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> globalException(Exception ex) {
        Map<String, Object> error = new HashMap<>();
        error.put("date", new Date());
        error.put("error", "Error en el servidor");
        error.put("message", ex.getMessage());
        error.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());

        return error;
    }

    @ExceptionHandler(value = { MethodArgumentNotValidException.class })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handlerValidationException(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMesage = error.getDefaultMessage();
            errors.put(fieldName, errorMesage);
        });

        return errors;
    }

    @ExceptionHandler(value = { DataAccessException.class })
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> handleRepositoryException(DataAccessException ex) {
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("date", new Date());
        errorResponse.put("error", "Error en base de datos");
        errorResponse.put("message", ex.getMessage());
        errorResponse.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        return errorResponse;
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, Object> noHandlerFoundException(NoHandlerFoundException ex) {
        Map<String, Object> error = new HashMap<>();
        error.put("date", new Date());
        error.put("error", "Recurso no encontrado");
        error.put("message", "La URL solicitada no existe.");
        error.put("status", HttpStatus.NOT_FOUND.value());
        return error;
    }

}
