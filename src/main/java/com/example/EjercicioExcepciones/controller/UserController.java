package com.example.EjercicioExcepciones.controller;

import com.example.EjercicioExcepciones.dtos.ResponseDTO;
import com.example.EjercicioExcepciones.dtos.UserDTO;
import com.example.EjercicioExcepciones.mapper.UserMapper;
import com.example.EjercicioExcepciones.service.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping ("/api/user")
    public ResponseDTO createUser(@RequestBody UserDTO userDTO){
        return userService.createUser(UserMapper.convertToModel(userDTO));
    }
}
