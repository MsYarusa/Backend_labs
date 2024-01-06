package com.example.tasklist.dto;


import lombok.*;

/*
Анотации Getter, Setter и NoArgsConstructor создают
геттеры, сеттеры для полей класса и конструктор без аргументов
 */
@Getter
@Setter
@NoArgsConstructor
public class ErrorDTO {
    private String message;

    public ErrorDTO(String message) {
        this.message = message;
    }

}
