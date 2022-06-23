package com.example.EjercicioExcepciones.utils;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import javax.mail.SendFailedException;

public class MailSender{
    private static JavaMailSender emailSender;

    public static void sendWarningMail(){
        emailSender.send(new SimpleMailMessage());
    }
}
