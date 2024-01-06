package com.example.tasklist.exception;

import org.springframework.http.HttpStatus;

//родительский класс для ошибок связанных с некоректным запросом
public class BadRequestException extends ApiException{
    public BadRequestException(String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }
}
