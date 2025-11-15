package com.devsenior.acaycedo.login_user.model.dto;

import java.time.LocalDate;

import com.devsenior.acaycedo.login_user.model.shared.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor

@Data

public class RegisterResponse {
    private String username;
    
    private String name;
    
    private String email;
    
    private String password;

    private LocalDate hirDate;

    private Boolean active;

    private Role role;
}
