package com.example.petshop.exception;

import lombok.AllArgsConstructor;


public class ExceptionClient extends RuntimeException{
    public ExceptionClient(String message) {
        super(message);
    }
}
