package com.devsenior.acaycedo.login_user.service;

import com.devsenior.acaycedo.login_user.model.dto.LoginRequest;
import com.devsenior.acaycedo.login_user.model.dto.RegisterRequest;
import com.devsenior.acaycedo.login_user.model.dto.RegisterResponse;

public interface AuthenticationService {
    RegisterResponse register(RegisterRequest userInfo);

    void login(LoginRequest body);
}
