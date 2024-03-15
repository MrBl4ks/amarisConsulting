package com.example.api.service;

import com.example.api.model.UserEmail;
import com.example.api.model.UserRequest;
import com.example.api.model.UserResponse;

public interface UserService {

    public String saveUserEmail(String email);
    public UserResponse userResponse(UserRequest userRequest);
    public boolean isAvailable(Integer id);
}
