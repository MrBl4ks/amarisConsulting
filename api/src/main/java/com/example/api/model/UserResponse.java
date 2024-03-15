package com.example.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Builder
public class UserResponse {
    private String id;
    private UserRequest user;
    private String token;
    private Date created;
    private Date modified;
    private Date last_login;
    private boolean isActive;

}
