package com.devsenior.acaycedo.login_user.model.dto;

import org.hibernate.validator.constraints.Length;

import com.devsenior.acaycedo.login_user.model.shared.Role;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RegisterRequest {

    @NotBlank(message = "El username es obligatorio")
    @Length(min = 5, message = "Minimo 5 caracteres")
    private String username;
    
    @NotBlank(message = "La contraseña es obligatorio")
    @Length(min = 6, message = "Minimo 6 caracteres")
    private String password;

    @NotBlank(message = "El nombre es obligatorio")
    @JsonProperty("full_name")
    @JsonAlias({"name","nombre"})
    private String name;
    
    @NotBlank(message = "El correo es obligatorio")
    @Email(message = "Formato invalido")
    private String email;
    
    @NotNull(message = "No puede quedar vacio")
    private Role role;
}
