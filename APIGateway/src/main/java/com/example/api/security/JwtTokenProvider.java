package com.example.api.security;

import io.jsonwebtoken.*;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class JwtTokenProvider {

    private final String secretKey = "yourSecretKey";
    private final long validity = 3600000; // 1 hour in milliseconds

    public boolean validateToken(String token) {
        try {
            Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }

    public Authentication getAuthentication(String token) {
        String username = Jwts.parser()
            .setSigningKey(secretKey)
            .parseClaimsJws(token)
            .getBody()
            .getSubject();

        List<String> roles = Jwts.parser()
            .setSigningKey(secretKey)
            .parseClaimsJws(token)
            .getBody()
            .get("roles", List.class);

        return new UsernamePasswordAuthenticationToken(username, null, roles.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList()));
    }

   
    public String createToken(String username, List<String> roles) {
        return Jwts.builder()
            .setSubject(username)
            .claim("roles", roles)  
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + validity))
            .signWith(SignatureAlgorithm.HS256, secretKey)
            .compact();
    }
}

