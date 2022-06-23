package com.example.EjercicioExcepciones.mapper;

import com.example.EjercicioExcepciones.dtos.UserDTO;
import com.example.EjercicioExcepciones.entities.UserEntity;
import com.example.EjercicioExcepciones.models.UserModel;

public class UserMapper {
    public static UserModel convertToModel(UserDTO userDTO){
        return new UserModel(userDTO.getUsername(), userDTO.getPassword());
    }
    public static UserEntity convertToEntity(UserModel userModel){
        return new UserEntity(userModel.getUsername(), userModel.getPassword());
    }
    public static UserDTO convertToDTO(UserModel userModel){
        return new UserDTO(userModel.getUsername(), userModel.getPassword());
    }
}
