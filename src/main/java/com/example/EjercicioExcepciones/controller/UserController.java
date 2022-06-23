package com.example.EjercicioExcepciones.controller;

import com.example.EjercicioExcepciones.dtos.ResponseDTO;
import com.example.EjercicioExcepciones.dtos.UserDTO;
import com.example.EjercicioExcepciones.service.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private UserServiceImpl userService;

    public UserController() {
        this.userService = new UserServiceImpl();
    }

    @PostMapping ("/api/user")
    public ResponseEntity<ResponseDTO> createUser(@RequestBody UserDTO userDTO){
        return new ResponseEntity<ResponseDTO>(new ResponseDTO("Se ha creado el usuario"),HttpStatus.CREATED);
    }
}
