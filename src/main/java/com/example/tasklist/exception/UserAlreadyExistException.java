package com.example.tasklist.exception;

public class UserAlreadyExistException extends BadRequestException{
    public UserAlreadyExistException(String message) {
        super(message);
    }
}
