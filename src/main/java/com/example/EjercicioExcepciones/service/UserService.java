package com.example.EjercicioExcepciones.service;

import com.example.EjercicioExcepciones.dtos.ResponseDTO;
import com.example.EjercicioExcepciones.dtos.UserDTO;
import com.example.EjercicioExcepciones.models.UserModel;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    ResponseDTO createUser(UserModel userModel);
}
