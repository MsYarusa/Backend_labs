package com.example.tasklist.contoller;

import com.example.tasklist.dto.UserWithoutPasswordDTO;
import com.example.tasklist.exception.UserAlreadyExistException;
import com.example.tasklist.exception.UserNotFoundException;
import com.example.tasklist.model.UserEntity;
import com.example.tasklist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//контроллер для пользователей
//контроллер связан с доменом "api/users"
@RestController
@RequestMapping("api/users")
public class UserController {
    // подключаем сервис, отвечающий за обработку запросов, связанных с пользователями
    @Autowired
    private UserService userService;

    //get запрос на получение пользователя по айдишнику
    //ожидает получить айдишник пользователя в query параметрах
    @GetMapping
    public ResponseEntity<?> getUser(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(userService.getUser(id));
        } catch (UserNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    //get запрос на всех пользователей
    //связан с доменом "/all"
    @GetMapping("/all")
    public ResponseEntity<?> getUser() {
        try {
            return ResponseEntity.ok(userService.getAllUser());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    //post запрос на регистрацию нового пользователя
    //ожидает получить нового пользователя в теле

    @PostMapping
    public ResponseEntity<?> postUser(@RequestBody UserEntity user) {
        try {
            return ResponseEntity.ok(userService.registerUser(user));
        } catch (UserAlreadyExistException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    //put запрос на обновление имени пользователя
    //ожидается получить айдишник пользователя в виде переменной пути
    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody UserWithoutPasswordDTO user) {
        try {
            return ResponseEntity.ok(userService.updateUser(id, user));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    //delete запрос на удаление пользователя
    //ожидается получить айдишник пользователя в виде переменной пути
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(userService.deleteUser(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
}