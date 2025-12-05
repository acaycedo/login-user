package com.devsenior.acaycedo.login_user.service;

import java.util.Map;

import org.springframework.security.core.userdetails.UserDetails;

public interface JwtService{
       String generateToken(UserDetails userDetails);
       String generateToken(Map<String, Object> claims, UserDetails userDetails);
       String extractUsername(String jwt);
}
