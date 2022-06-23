package com.example.EjercicioExcepciones.service;


import com.example.EjercicioExcepciones.dtos.ResponseDTO;
import com.example.EjercicioExcepciones.entities.UserEntity;
import com.example.EjercicioExcepciones.exception.NoConnectionEstablishedNoSQLBD;
import com.example.EjercicioExcepciones.exception.NoConnectionEstablishedSQLBD;
import com.example.EjercicioExcepciones.exception.NoConnectionException;
import com.example.EjercicioExcepciones.exception.SavingUserException;
import com.example.EjercicioExcepciones.mapper.UserMapper;
import com.example.EjercicioExcepciones.models.UserModel;
import com.example.EjercicioExcepciones.repository.UserRepository;
import com.example.EjercicioExcepciones.repository.UserRepositoryBDSQLImpl;
import com.example.EjercicioExcepciones.repository.UserRepositoryBdNoSQLImpl;
import com.example.EjercicioExcepciones.utils.MailSender;
import com.example.EjercicioExcepciones.utils.FileRecorder;
import com.example.EjercicioExcepciones.utils.QueueManager;
import com.example.EjercicioExcepciones.utils.SlackSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService{

    UserRepository userRepository;

    public UserServiceImpl() {
        this.userRepository = new UserRepositoryBDSQLImpl();
    }

    public ResponseDTO createUser(UserModel userModel) {
        UserEntity userEntity= UserMapper.convertToEntity(userModel);
        try {
            if (userRepository.findByUsernameAndPassword(userEntity.getUsername(), userEntity.getPassword())) {
                MailSender.sendWarningMail();
            } else {
                userRepository = new UserRepositoryBdNoSQLImpl();
                boolean isSaved = userRepository.save(userEntity.getUsername(), userEntity.getPassword());
                if (!isSaved) {
                    throw new SavingUserException("No se puede guardar el usuario ingresado");
                }
                SlackSender.sendMessage(userModel);
                QueueManager.sendMessage(userModel);
            }
        }
        catch (NoConnectionEstablishedSQLBD e){
            e.printStackTrace();
            throw new NoConnectionException("No se pudo establecer una conexion con el servidor, intente nuevamente");
        }
        catch (NoConnectionEstablishedNoSQLBD e){
            e.printStackTrace();
            throw new NoConnectionException("No se pudo establecer una conexion con el servidor, intente nuevamente");
        }
        FileRecorder.write("Create user operation "+ LocalDateTime.now());
        return new ResponseDTO("Se ha creado el user");
    }

}
