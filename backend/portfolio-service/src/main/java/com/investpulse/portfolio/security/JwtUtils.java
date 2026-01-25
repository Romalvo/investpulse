package com.investpulse.portfolio.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;

@Component
public class JwtUtils {

    @Value("${jwt.secret}")
    private String jwtSecret;
    private Key key;

    @PostConstruct
    public void init(){
        System.out.println("=================================");
        System.out.println("JWT Secret loaded (first 10 chars): " + jwtSecret.substring(0, Math.min(10, jwtSecret.length())));
        System.out.println("JWT Secret loaded (last 10 chars): " + jwtSecret.substring(Math.max(0, jwtSecret.length() - 10)));
        System.out.println("JWT Secret length: " + jwtSecret.length());
        System.out.println("=================================");

        byte[] secretBytes = jwtSecret.getBytes();
        key = Keys.hmacShaKeyFor(secretBytes);
    }

    public boolean validateToken(String token){
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        } catch (JwtException | IllegalArgumentException ex) {
            return false;
        }
    }

    public String extractEmail(String token) {
        Claims claims = Jwts.parserBuilder().setSigningKey(key).build()
                .parseClaimsJws(token).getBody();
        return claims.getSubject();
    }
}
