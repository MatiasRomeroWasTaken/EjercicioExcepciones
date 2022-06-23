package com.example.EjercicioExcepciones.repository;

import com.example.EjercicioExcepciones.exception.NoConnectionEstablishedNoSQLBD;
import com.example.EjercicioExcepciones.exception.NoConnectionEstablishedSQLBD;

public class UserRepositoryBdNoSQLImpl implements UserRepository {
    private boolean hasConnection=true;
    @Override
    public boolean findByUsernameAndPassword(String username, String password) {
        return false;
    }

    @Override
    public boolean save(String username, String password) throws NoConnectionEstablishedNoSQLBD {
        if(!hasConnection){
            throw new NoConnectionEstablishedNoSQLBD("ERROR NO CONNECTION ESTABLISHED");
        }
        return false;
    }
}
