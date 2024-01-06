package com.example.tasklist.service;

import com.example.tasklist.dto.TodoWithoutUserDTO;
import com.example.tasklist.exception.FieldIsNullException;
import com.example.tasklist.exception.TodoNotFoundException;
import com.example.tasklist.exception.UserNotFoundException;
import com.example.tasklist.model.TodoEntity;
import com.example.tasklist.model.UserEntity;
import com.example.tasklist.repository.TodoRepo;
import com.example.tasklist.repository.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

//сервис для задач
@Service
public class TodoService {
    //подключаем репозитории и маппер
    @Autowired
    private TodoRepo todoRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ModelMapper modelMapper;

    //сервис обработки post запроса для задач
    public TodoWithoutUserDTO createTodo(TodoEntity todo, Long userId) throws UserNotFoundException, FieldIsNullException {
        //ищем запись о пользователе в таблице по айди
        Optional<UserEntity> row = userRepo.findById(userId);
        //если записи нет, то бросаем исключение
        if(row.isEmpty()){
            throw new UserNotFoundException("Пользователь не найден");
        }

        if (todo.getCompleted() == null){
            throw new FieldIsNullException("Статус задачи не указан");
        }

        if (todo.getTitle() == null){
            throw new FieldIsNullException("Название задачи не указано");
        }
        //связываем задачу и пользователя
        UserEntity user = row.get();
        todo.setUser(user);
        //сохраняем задачу и возвращаем ее dto
        return modelMapper.map(todoRepo.save(todo), TodoWithoutUserDTO.class);
    }

    //сервис обработки put запроса для задач
    public TodoWithoutUserDTO completeTodo(Long id) throws TodoNotFoundException {
        //ищем запись о задаче в таблице по ее айди
        Optional<TodoEntity> row = todoRepo.findById(id);
        // если записи нет, то бросаем исключение
        if (row.isEmpty()){
            throw new TodoNotFoundException("Todo не найдено");
        }
        //меняем статус задач
        TodoEntity todo = row.get();
        todo.setCompleted(!todo.getCompleted());
        //сохраняем задачу и возвращаем ее dto
        return modelMapper.map(todoRepo.save(todo), TodoWithoutUserDTO.class);
    }

    //сервис обработки delete запроса для задач
    public Long deleteTodo(Long id){
        //удаляем задачу из таблицы и возращаем ее айди
        todoRepo.deleteById(id);
        return id;
    }
}
