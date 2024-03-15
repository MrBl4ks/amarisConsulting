package com.example.api.controller;

import com.example.api.model.UserEmail;
import com.example.api.model.UserRequest;
import com.example.api.model.UserResponse;
import com.example.api.security.JwtIssuer;
import com.example.api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {

    private final JwtIssuer jwtIssuer;


    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<Object> save(@RequestBody @Validated UserRequest user){
        var token = jwtIssuer.issue("id", user.getName(), user.getEmail());
        UUID uuid = UUID.randomUUID();
        ResponseEntity<String> responseEntity = null;
        try{
            String email = userService.saveUserEmail("");
        }catch(Exception e){
            responseEntity = new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(UserResponse.builder()
                .id(uuid.toString())
                .user(user)
                .token(token)
                .created(new Date())
                .modified(new Date())
                .last_login(new Date())
                .isActive(true).build());
    }
}
