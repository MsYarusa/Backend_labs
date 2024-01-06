package com.example.tasklist.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/*
Анотации Getter, Setter и NoArgsConstructor создают
геттеры, сеттеры для полей класса и конструктор без аргументов
*/
@Getter
@Setter
@NoArgsConstructor
public class UserWithoutPasswordDTO {
    // DTO класс для пользователя, чтобы не отправлять пароль
    private Long id;
    private String username;
    private List<TodoWithoutUserDTO> todos;
}
