package com.example.tasklist.dto;

import lombok.*;

/*
Анотация Getter реализует геттеры
AllArgsConstructor создает конструктор со всеми полями для данного класса
 */
@Getter
@AllArgsConstructor
public class ErrorResponseDTO {
    private ErrorDTO error;
}
