package com.example.tasklist.repository;

import com.example.tasklist.model.UserEntity;
import org.springframework.data.repository.CrudRepository;

//репозиторий необходим для взаимодействия с бд
public interface UserRepo extends CrudRepository<UserEntity, Long> {
    //определяем метод нахождения пользователя по имени
    UserEntity findByUsername(String username);
}
