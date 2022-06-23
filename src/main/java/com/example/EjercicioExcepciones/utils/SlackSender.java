package com.example.EjercicioExcepciones.utils;

import com.example.EjercicioExcepciones.exception.NoChannelFoundSlack;
import com.example.EjercicioExcepciones.exception.NoConnectionEstablishedSlack;
import com.example.EjercicioExcepciones.models.UserModel;

public class SlackSender {

    private static boolean hasConnection=true;

    public static void sendMessage(UserModel userModel) {
        if(!findChannel()){
            throw new NoChannelFoundSlack("No se pudo establecer una conexion con slack");
        }
        if(hasConnection){

        }
        else
            throw new NoConnectionEstablishedSlack("No se pudo establecer una conexion con slack");
    }

    private static boolean findChannel() {
        return true;
    }

}
