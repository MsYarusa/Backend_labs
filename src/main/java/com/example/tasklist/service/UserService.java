package com.example.tasklist.service;

import com.example.tasklist.dto.UserOnlyUserNameDTO;
import com.example.tasklist.dto.UserWithoutPasswordDTO;
import com.example.tasklist.exception.FieldIsNullException;
import com.example.tasklist.exception.UserAlreadyExistException;
import com.example.tasklist.exception.UserNotFoundException;
import com.example.tasklist.model.UserEntity;
import com.example.tasklist.repository.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//сервис для пользователей
@Service
public class UserService {
    //подключаем репозиторий для пользователей и маппер
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    //сервис получения пользователя по айди
    public UserWithoutPasswordDTO getUser (Long id) throws UserNotFoundException {
        // получаем запись о пользователе из таблице по айди
        Optional<UserEntity> row = userRepo.findById(id);
        // если запись не найдена, то бросаем исключение
        if (row.isEmpty()){
            throw new UserNotFoundException("Пользователь не найден");
        }
        // возвращаем DTO пользователя
        UserEntity user = row.get();
        return modelMapper.map(user, UserWithoutPasswordDTO.class);
    }

    //сервис получения всех пользователей
    public List<UserOnlyUserNameDTO> getAllUser () {
        // получаем список всех пользователей из репазитория
        // преобразуем каждого пользователя в DTO

        return Streamable.of(userRepo.findAll()).stream()
                        .map(user -> modelMapper.map(user, UserOnlyUserNameDTO.class)).toList();
    }

    //сервис регистрации
    public UserWithoutPasswordDTO registerUser(UserEntity user) throws UserAlreadyExistException {
        // проверяем есть ли уже пользователь с указанным именем
        if(userRepo.findByUsername(user.getUsername()) != null){
            throw new UserAlreadyExistException("Пользователь с таким именем существует");
        }
        return modelMapper.map(userRepo.save(user), UserWithoutPasswordDTO.class);
    }

    //сервис обновления имени пользователя
    public UserWithoutPasswordDTO updateUser(Long id, UserWithoutPasswordDTO newUser) throws UserNotFoundException, FieldIsNullException {
        // получаем запись о пользователе из таблице по айди
        Optional<UserEntity> row = userRepo.findById(id);
        // если запись не найдена, то бросаем исключение
        if (row.isEmpty()){
            throw new UserNotFoundException("Пользователь не найден");
        }

        UserEntity user = row.get();
        //проверяем новое имя на null. Если оно не указано, то кидаем исключение
        if (newUser.getUsername() != null) user.setUsername(newUser.getUsername());
        else{
            throw new FieldIsNullException("Имя пользователя не указано");
        }
        //возвращаем DTO пользователя
        return modelMapper.map(userRepo.save(user), UserWithoutPasswordDTO.class);
    }

    //сервис удаления пользователя
    public Long deleteUser(Long id){
        //удаляем пользователя из таблицы и возвращаем его айди
        userRepo.deleteById(id);
        return id;
    }
}
