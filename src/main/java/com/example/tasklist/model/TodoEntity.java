package com.example.tasklist.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
@Table(name = "todos")
public class TodoEntity {
    /*
     Показываем первичный ключ и способ генерации.
     Способ генерации IDENTITY использует встроенный в БД
     тип данных - identity для генерации первичного ключа
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Boolean completed;

    // настраиваем связь многие-к-одному с таблицей users
    // внешним ключом будет выступать колонка user_id
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
}
