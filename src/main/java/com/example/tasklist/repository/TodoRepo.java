package com.example.tasklist.repository;

import com.example.tasklist.model.TodoEntity;
import org.springframework.data.repository.CrudRepository;

//репозиторий необходим для взаимодействия с бд
public interface TodoRepo extends CrudRepository<TodoEntity, Long> {
}
