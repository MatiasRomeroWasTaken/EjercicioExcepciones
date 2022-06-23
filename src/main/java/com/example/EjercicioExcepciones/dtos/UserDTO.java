package com.example.EjercicioExcepciones.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UserDTO {

    @NotBlank(message = "El username no tiene que estar vacio")
    private String username;
    @NotBlank(message = "La password no tiene que estar vacia")
    private String password;
}
