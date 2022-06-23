package com.example.EjercicioExcepciones.repository;

import com.example.EjercicioExcepciones.exception.NoConnectionEstablishedSQLBD;

public interface UserRepository {
    boolean findByUsernameAndPassword(String username, String password) throws NoConnectionEstablishedSQLBD;
    boolean save(String username, String password);
}
