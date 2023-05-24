package ru.hard2code.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ru.hard2code.exception.AccountNotFoundException;
import ru.hard2code.exception.AmountExceedException;
import ru.hard2code.exception.ApiException;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class CustomControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(AccountNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleAccountNotFound(
            Exception ex,
            HttpServletRequest request) {
        logger.error(ex.getMessage(), ex);
        return errorEntity(ex, request, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AmountExceedException.class)
    public ResponseEntity<Map<String, Object>> handleAmountExceed(Exception ex,
                                                                  HttpServletRequest request) {
        logger.error(ex.getMessage(), ex);
        return errorEntity(ex, request, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<Map<String, Object>> handleApiErrors(Exception ex,
                                                               HttpServletRequest request) {
        logger.error(ex.getMessage(), ex);
        return errorEntity(ex, request, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    private ResponseEntity<Map<String, Object>> errorEntity(Exception ex,
                                                            HttpServletRequest request,
                                                            HttpStatus httpStatus) {
        Map<String, Object> params = new HashMap<>();
        params.put("error", httpStatus.getReasonPhrase());
        params.put("message", ex.getMessage());
        params.put("path", request.getRequestURI());
        params.put("status", httpStatus.value());
        params.put("timestamp", LocalDateTime.now());

        return new ResponseEntity<>(params, httpStatus);
    }


}
