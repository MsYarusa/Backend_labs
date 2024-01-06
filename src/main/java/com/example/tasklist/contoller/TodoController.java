package com.example.tasklist.contoller;

import com.example.tasklist.exception.ApiControllerExceptionHandler;
import com.example.tasklist.exception.FieldIsNullException;
import com.example.tasklist.exception.TodoNotFoundException;
import com.example.tasklist.exception.UserNotFoundException;
import com.example.tasklist.model.TodoEntity;
import com.example.tasklist.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// контроллер для задач
// контроллер связан с доменом "api/todos"
@RestController
@RequestMapping("api/todos")
@ApiControllerExceptionHandler
public class TodoController {
    // подключаем сервис, отвечающий за обработку запросов, связанных с задачами
    @Autowired
    private TodoService todoService;

    //post запрос на создание новой задачи
    //ожидает получить задачу в теле и айдишник пользователя (с которым связывается задача) в query параметрах
    @PostMapping
    public ResponseEntity<?> createTodo(@RequestBody TodoEntity todo, @RequestParam Long userId) throws UserNotFoundException, FieldIsNullException {
        return ResponseEntity.ok(todoService.createTodo(todo, userId));
    }

    //put запрос на обновление статуса задачи
    //ожидается получить айдишник задачи в виде переменной пути
    @PutMapping("/{id}")
    public ResponseEntity<?> completeTodo(@PathVariable Long id) throws TodoNotFoundException {
        return ResponseEntity.ok(todoService.completeTodo(id));
    }

    //delete запрос на удаление задачи
    //ожидается получить айдишник задачи в виде переменной пути
    @DeleteMapping("/{id}")
    public  ResponseEntity<?> deleteTodo(@PathVariable Long id){
        return ResponseEntity.ok(todoService.deleteTodo(id));
    }
}
