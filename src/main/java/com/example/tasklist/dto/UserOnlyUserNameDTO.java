package com.example.tasklist.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
Анотации Getter, Setter и NoArgsConstructor создают
геттеры, сеттеры для полей класса и конструктор без аргументов
*/
@Getter
@Setter
@NoArgsConstructor
public class UserOnlyUserNameDTO {
    // DTO класс для пользователя, содержащее только имя
    private Long id;
    private String username;
}
