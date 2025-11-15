package com.devsenior.acaycedo.login_user.model.entity;

import java.time.LocalDate;

import com.devsenior.acaycedo.login_user.model.shared.Role;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder //Builder que usaremos para construir el usuario a partir del Mapper
@NoArgsConstructor //Para que hibernate funcione necesita un constructor vacio
@AllArgsConstructor // Y para que funcione el Builder necesita un contructor con todos los parametros
@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    private String username;
    
    private String name;
    
    private String email;
    
    private String password;

    private LocalDate hirDate;

    private Boolean active;

    private Role role;

}
