package com.devsenior.acaycedo.login_user.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsenior.acaycedo.login_user.model.dto.LoginRequest;
import com.devsenior.acaycedo.login_user.model.dto.RegisterRequest;
import com.devsenior.acaycedo.login_user.model.dto.RegisterResponse;
import com.devsenior.acaycedo.login_user.service.AuthenticationService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor //para usar el private final 
@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    
    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    public void login(@RequestBody LoginRequest body){
        authenticationService.login(body);
    }

    @PostMapping("/register")
    public RegisterResponse register(@RequestBody @Valid RegisterRequest body){ //@Valid validacion de los DTO que debe cumplir con x funcion
        return authenticationService.register(body);
    }
}
