package com.example.tasklist.contoller;

import com.example.tasklist.dto.UserWithoutPasswordDTO;
import com.example.tasklist.exception.ApiControllerExceptionHandler;
import com.example.tasklist.exception.FieldIsNullException;
import com.example.tasklist.exception.UserAlreadyExistException;
import com.example.tasklist.exception.UserNotFoundException;
import com.example.tasklist.model.UserEntity;
import com.example.tasklist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//контроллер для пользователей
//контроллер связан с доменом "api/users"
//ошибки вызванные в контроллере обрабатываются во внешнем классе
@RestController
@RequestMapping("api/users")
@ApiControllerExceptionHandler
public class UserController {
    // подключаем сервис, отвечающий за обработку запросов, связанных с пользователями
    @Autowired
    private UserService userService;

    //get запрос на получение пользователя по айдишнику
    //ожидает получить айдишник пользователя в query параметрах
    @GetMapping
    public ResponseEntity<?> getUser(@RequestParam Long id) throws UserNotFoundException {
            return ResponseEntity.ok(userService.getUser(id));
    }

    //get запрос на всех пользователей
    //связан с доменом "/all"
    @GetMapping("/all")
    public ResponseEntity<?> getUser() {
        return ResponseEntity.ok(userService.getAllUser());
    }

    //post запрос на регистрацию нового пользователя
    //ожидает получить нового пользователя в теле

    @PostMapping
    public ResponseEntity<?> postUser(@RequestBody UserEntity user) throws UserAlreadyExistException, FieldIsNullException {
        return ResponseEntity.ok(userService.registerUser(user));
    }

    //put запрос на обновление имени пользователя
    //ожидается получить айдишник пользователя в виде переменной пути
    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody UserWithoutPasswordDTO user) throws UserNotFoundException, FieldIsNullException {
            return ResponseEntity.ok(userService.updateUser(id, user));
    }

    //delete запрос на удаление пользователя
    //ожидается получить айдишник пользователя в виде переменной пути
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
            return ResponseEntity.ok(userService.deleteUser(id));
    }
}