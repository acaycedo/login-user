package com.devsenior.acaycedo.login_user.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.devsenior.acaycedo.login_user.exception.BadLoginException;
import com.devsenior.acaycedo.login_user.mapper.UserMapper;
import com.devsenior.acaycedo.login_user.model.dto.LoginRequest;
import com.devsenior.acaycedo.login_user.model.dto.RegisterRequest;
import com.devsenior.acaycedo.login_user.model.dto.RegisterResponse;
import com.devsenior.acaycedo.login_user.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service

public class AuthenticationServicePostgresql implements AuthenticationService {
    
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    
    @Override
    public RegisterResponse register(RegisterRequest userInfo) {
        // TODO: Verificar que el username no exista en la base de datos;

        // TODO: Verificar que el email no exita en la base de datos

        // Creo una entidad con los datos del request
        var user = userMapper.toEntity(userInfo);
        // Guardo en la base de datos
        user= userRepository.save(user);
        // Convierto el objeto guardado a response
        var response = userMapper.toResponse(user);
        // Devuelvo el response
        return response;
    }

    @Override
    public void login(LoginRequest credentials) {
        if (!userRepository.existByUsernameAndPassword(credentials.getUsername(), passwordEncoder.encode(credentials.getPassword()))) {
            throw new BadLoginException();
        }        
    }
    
    
}
