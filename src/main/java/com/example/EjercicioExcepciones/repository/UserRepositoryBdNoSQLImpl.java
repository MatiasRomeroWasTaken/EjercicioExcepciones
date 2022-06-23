package com.example.EjercicioExcepciones.repository;

public class UserRepositoryBdNoSQLImpl implements UserRepository {
    @Override
    public boolean findByUsernameAndPassword(String username, String password) {
        return false;
    }

    @Override
    public boolean save(String username, String password) {
        return false;
    }
}
