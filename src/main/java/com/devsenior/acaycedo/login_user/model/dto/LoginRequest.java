package com.devsenior.acaycedo.login_user.model.dto;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginRequest {
    
    @NotBlank(message = "El username es obligatorio")
    @Length(min = 5, message = "Minimo 5 caracteres")
    private String username;
@NotBlank(message = "La contraseña es obligatorio")
    @Length(min = 6, message = "Minimo 6 caracteres")
    private String password;
}
