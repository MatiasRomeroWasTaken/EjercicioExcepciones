package com.example.EjercicioExcepciones.exception;

import com.example.EjercicioExcepciones.dtos.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class handlerException {


    @ExceptionHandler({
            SavingUserException.class,
            RuntimeException.class
    })
    public ResponseEntity<ResponseDTO> handleNotFoundException(RuntimeException e) {
        return new ResponseEntity<>(new ResponseDTO(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
