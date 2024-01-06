package com.example.tasklist.exception;

import org.springframework.http.HttpStatus;

//родительский класс для ошибок связанных с отсутствием искомых данных
public class NotFoundException extends ApiException{
    public NotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
