package com.example.tasklist.exception;

public class TodoNotFoundException extends NotFoundException {
    public TodoNotFoundException(String message) {
        super(message);
    }
}
