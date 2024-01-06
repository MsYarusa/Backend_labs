package com.example.tasklist.exception;

import java.lang.annotation.*;

//пользовательская аннотация, которая нужно чтобы показать в каких контроллерах обрабатывать ошибки
@Retention(RetentionPolicy.RUNTIME)
public @interface ApiControllerExceptionHandler {
}
