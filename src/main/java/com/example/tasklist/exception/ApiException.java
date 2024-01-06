package com.example.tasklist.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

// родительский класс для всех ошибок возникающих в приложении
@Getter
public class ApiException extends Exception{
    //храним статус ошибки
    private final HttpStatus httpStatus;

    public ApiException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
