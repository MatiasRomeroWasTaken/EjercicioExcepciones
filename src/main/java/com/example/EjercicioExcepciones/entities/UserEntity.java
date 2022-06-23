package com.example.EjercicioExcepciones.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UserEntity {
    private Integer id;
    private String username;
    private String password;

    public UserEntity(String username, String password) {
        this.id=null;
        this.username=username;
        this.password=password;
    }
}
