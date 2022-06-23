package com.example.EjercicioExcepciones.exception;

import com.example.EjercicioExcepciones.dtos.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HandlerException {


    @ExceptionHandler({
            SavingUserException.class,
            NoConnectionException.class,
            FileAlreadyOpenException.class,
            FileWasNotAbleToWrite.class,
            FileWasNotFound.class,
            MailWasNotSent.class,
            NoChannelFoundSlack.class,
            NoConnectionEstablishedSlack.class,
            NoConnectionEstablishedQueue.class,
            OriginMailNotAvaible.class,
            QueueIsFullException.class,
            RuntimeException.class
    })
    public ResponseEntity<ResponseDTO> handleInternalServerErrorException(RuntimeException e) {
        return new ResponseEntity<>(new ResponseDTO("Se produjo un problema interno. Porfavor intentelo mas tarde"), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({
            UserAlreadyCreatedException.class,
            DataSentInvalidType.class
    })
    public ResponseEntity<ResponseDTO> handleBadRequstException(RuntimeException e) {
        return new ResponseEntity<>(new ResponseDTO(e.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
