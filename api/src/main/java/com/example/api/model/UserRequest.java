package com.example.api.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Builder
public class UserRequest {

    private String name;
    private String email;
    private String password;
    private List<Phone> phone;
}
