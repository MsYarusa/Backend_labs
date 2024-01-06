package com.example.tasklist.exception;

public class FieldIsNullException extends BadRequestException{
    public FieldIsNullException(String message) {
        super(message);
    }
}
