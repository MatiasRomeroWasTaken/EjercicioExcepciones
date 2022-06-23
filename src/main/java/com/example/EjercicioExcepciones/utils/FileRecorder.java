package com.example.EjercicioExcepciones.utils;

import com.example.EjercicioExcepciones.exception.DataSentInvalidType;
import com.example.EjercicioExcepciones.exception.FileAlreadyOpenException;
import com.example.EjercicioExcepciones.exception.FileWasNotAbleToWrite;
import com.example.EjercicioExcepciones.exception.FileWasNotFound;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ResourceUtils;

import javax.activation.UnsupportedDataTypeException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Slf4j
public class FileRecorder {

    public static void write(String message){
        File file;
        try {
            file = ResourceUtils.getFile("SOMESOME");

        }
        catch (FileNotFoundException e){
            throw new FileWasNotFound("No se encontro el archivo");
        }
        catch (FileAlreadyOpenException e){
            throw new FileAlreadyOpenException("El archivo solicitado se encuentra abierto");
        }
        try {
            Files.write(Path.of(file.getPath()),message.getBytes());
        }
        catch (UnsupportedDataTypeException e){
            throw new DataSentInvalidType("El formato de los datos es invalido");
        }
        catch (IOException e) {
            throw new FileWasNotAbleToWrite("No se puede escribir al archivo");
        }


    }
}
