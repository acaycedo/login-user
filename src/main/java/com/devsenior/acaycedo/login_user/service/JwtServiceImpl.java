package com.devsenior.acaycedo.login_user.service;

import java.util.Date;
import java.util.Map;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

//Por ahora solo como clase ya que recuerden que el servicio debe implementarse por una clase padre
@Service
public class JwtServiceImpl implements JwtService {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private Long expiration;

    @Override
    public String generateToken(UserDetails userDetails) {
        return generateToken(Map.of(), userDetails);
    }

    @Override
    public String generateToken(Map<String, Object> claims, UserDetails userDetails) {
        var secretKey = Keys.hmacShaKeyFor(secret.getBytes());
        return Jwts.builder()
                .claims(claims)
                .subject(userDetails.getUsername())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(secretKey, Jwts.SIG.HS256)
                .compact();
    }

    @Override
    public String extractUsername(String jwt) {
        return extractClaim(jwt, Claims::getSubject);//Toma el subjeto que es el usuario en el claim
    }
     //Esta funcion tiene encargada de sacar la segunda parte que es el Pailot
    private <T> T extractClaim(String token, Function<Claims, T> claimResolver){
        var claims = extractAllClaim(token);
        return claimResolver.apply(claims);
    }
    
    //Y esos Pailots en la biblioteca se llaman Claims
    private Claims extractAllClaim(String token) {
          var secretKey = Keys.hmacShaKeyFor(secret.getBytes());
        return Jwts.parser() //Lector de Jwts que va verificar el token
        .verifyWith(secretKey)//con esta key
        .build()//Genera el Parser osea un objeto que valida tokens
        .parseSignedClaims(token) // Luego pide que decodifique ese token
        .getPayload(); //y de ese token tome el pailot
    }

}
