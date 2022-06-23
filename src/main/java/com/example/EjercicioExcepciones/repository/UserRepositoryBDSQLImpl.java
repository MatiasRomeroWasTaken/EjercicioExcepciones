package com.example.EjercicioExcepciones.repository;

import com.example.EjercicioExcepciones.exception.NoConnectionEstablishedSQLBD;

public class UserRepositoryBDSQLImpl implements UserRepository {

    private boolean isCreated=false;
    private boolean hasConnection=true;

    @Override
    public boolean findByUsernameAndPassword(String username, String password) throws NoConnectionEstablishedSQLBD {
        if(!hasConnection){
            throw new NoConnectionEstablishedSQLBD("ERROR NO CONNECTION ESTABLISHED");
        }
        if(!isCreated){
            return false;
        }
        return true;
    }

    @Override
    public boolean save(String username, String password) {
        return false;
    }
}
