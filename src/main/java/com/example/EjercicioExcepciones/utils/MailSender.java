package com.example.EjercicioExcepciones.utils;

import com.example.EjercicioExcepciones.exception.MailWasNotSent;
import com.example.EjercicioExcepciones.exception.OriginMailNotAvaible;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import javax.mail.SendFailedException;

public class MailSender{
    private static JavaMailSender emailSender;

    public static void sendWarningMail(){
        if(!emailIsAvailable()){
            throw new OriginMailNotAvaible("El mail de origen no se puede enviar");
        }
        emailSender.send(new SimpleMailMessage());
        if(!emailWasSent()){
            throw new MailWasNotSent("No se pudo enviar mail");
        }
    }

    private static boolean emailWasSent() {
        return true;
    }
    private static boolean emailIsAvailable() {
        return true;
    }
}
