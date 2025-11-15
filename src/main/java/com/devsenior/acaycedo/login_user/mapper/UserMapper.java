package com.devsenior.acaycedo.login_user.mapper;

import java.time.LocalDate;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.devsenior.acaycedo.login_user.model.dto.RegisterRequest;
import com.devsenior.acaycedo.login_user.model.dto.RegisterResponse;
import com.devsenior.acaycedo.login_user.model.entity.User;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserMapper {

    private final PasswordEncoder passwordEncoder;

    public User toEntity(RegisterRequest request){
        return User.builder()
            .username(request.getUsername())
            .password(passwordEncoder.encode(request.getPassword()))
            .name(request.getName())
            .email(request.getEmail())
            .role(request.getRole())
            .active(true)
            .hirDate(LocalDate.now())
            .build();
    }

    public RegisterResponse toResponse(User user){
        return RegisterResponse.builder()
        .username(user.getUsername())
        .name(user.getName())
        .email(user.getEmail())
        .role(user.getRole())
        .hirDate(user.getHirDate())
        .active(user.getActive())
        .build();

    }
    
}
