package com.example.petshop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class GlobalException {
    @ExceptionHandler(InvalidValueException.class)
    public ResponseEntity<ErrorBody> handleInvalidValueException(InvalidValueException invalidValueException, HttpServletRequest request) {
        List<String> errorMessage=new ArrayList<>();
        errorMessage.add(invalidValueException.getMessage());
        ErrorBody errorBody = new ErrorBody(LocalDateTime.now(), 400, "bad request", errorMessage, request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorBody);
    }

}
