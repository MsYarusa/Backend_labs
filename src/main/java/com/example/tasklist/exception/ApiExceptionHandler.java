package com.example.tasklist.exception;

import com.example.tasklist.dto.ErrorDTO;
import com.example.tasklist.dto.ErrorResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice(annotations = ApiControllerExceptionHandler.class)
// с помощью аннотации ControllerAdvice указываем в каких контроллер отлавливаем ошибки
// наследуемся от класса который обрабатывает базовые ошибки, типо некорректного JSON и так далее
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
    //метод для обработки ошибок
    @org.springframework.web.bind.annotation.ExceptionHandler(ApiException.class)
    public ResponseEntity<?> handleCreationException(ApiException exception) {
        //преобразуем ошибку в DTO
        ErrorDTO error = new ErrorDTO(exception.getMessage());
        //оборачиваем ошибку в Response DTO
        ErrorResponseDTO result = new ErrorResponseDTO(error);

        return ResponseEntity.status(exception.getHttpStatus()).body(result);
    }
}
