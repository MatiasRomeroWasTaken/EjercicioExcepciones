package com.example.EjercicioExcepciones.utils;

import com.example.EjercicioExcepciones.exception.NoConnectionEstablishedQueue;
import com.example.EjercicioExcepciones.exception.NoConnectionEstablishedSlack;
import com.example.EjercicioExcepciones.exception.QueueIsFullException;
import com.example.EjercicioExcepciones.models.UserModel;

public class QueueManager {


    public static void sendMessage(UserModel userModel) {
        if(!checkConnectionWithLegacy()){
            throw new NoConnectionEstablishedQueue("No se puede establecer conexion con el servidor legacy");
        }
        if(checkIfQueueIsFull()){
            throw new QueueIsFullException("La queue esta llena");
        }
    }

    private static boolean checkIfQueueIsFull() {
        return true;
    }

    private static boolean checkConnectionWithLegacy() {
        return true;
    }
}
