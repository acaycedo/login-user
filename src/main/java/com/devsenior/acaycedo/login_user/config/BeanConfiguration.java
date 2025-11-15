package com.devsenior.acaycedo.login_user.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.devsenior.acaycedo.login_user.mapper.UserMapper;

@Configuration
public class BeanConfiguration {
    
    @Bean
    UserMapper userMapper(PasswordEncoder passwordEncoder){
        return new UserMapper(passwordEncoder);
    }
}
