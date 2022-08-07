package com.example.petshop.exception;

public class InvalidValueException extends RuntimeException{

    public InvalidValueException(String message) {
        super(message);
    }
}
