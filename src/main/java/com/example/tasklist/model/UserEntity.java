package com.example.tasklist.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/*
Анотации Getter, Setter и NoArgsConstructor создают
геттеры, сеттеры для полей класса и конструктор без аргументов.
Благодаря аннотации Entity мы можем хранить наш класс в базе данных.
Аннотация Table связывает нашу сущность с указанной таблицей
 */
@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class UserEntity {
    /*
     Показываем первичный ключ и способ генерации.
     Способ генерации IDENTITY использует встроенный в БД
     тип данных - identity для генерации первичного ключа
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;

    //настраиваем связь с таблицей todos один-ко-многим
    //указываем каскадное удаление. и поле по которому будет осуществляться связь
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<TodoEntity> todos;
}
