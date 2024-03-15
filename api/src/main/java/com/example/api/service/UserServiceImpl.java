package com.example.api.service;

import com.example.api.model.UserEmail;
import com.example.api.model.UserRequest;
import com.example.api.model.UserResponse;
import com.example.api.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    @Override
    @Transactional
    public String saveUserEmail(String email) {
        if(!validateEmail(email)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El correo electronico no tiene el formato deseado 'correo@dominio.cl");
        }
        return email;
    }

    @Override
    @Transactional
    public UserResponse userResponse(UserRequest userRequest) {
        if(!validatePassword(userRequest.getPassword())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "La clave debe seguir una expresión regular para validar que formato sea el correcto. (Una\n" +
                    "Mayuscula, letras minusculas, y dos numeros) ");
        }
        return null;
    }

    @Override
    @Transactional
    public boolean isAvailable(Integer id) {
        return true;
    }

    public static boolean validateEmail(String email) {
        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean validatePassword(String password){
        String PASSWORD_PATTERN = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d.*\\d)[A-Za-z\\d]{4,}$";
        Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
}
