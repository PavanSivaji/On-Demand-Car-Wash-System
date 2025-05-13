	package com.example.api.controllers;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.example.api.security.JwtTokenProvider;

import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtTokenProvider jwtTokenProvider;

    public AuthController(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Map<String, String>> login(@RequestBody Map<String, String> credentials) {
        String username = credentials.get("username");
        String password = credentials.get("password");

        // Define roles for the users
        if ("admin".equals(username) && "Admin@123".equals(password)) {
            String token = jwtTokenProvider.createToken(username, List.of("ROLE_ADMIN"));
            return Mono.just(Map.of("token", "Bearer " + token));
        } else if ("washer".equals(username) && "Washer@123".equals(password)) {
            String token = jwtTokenProvider.createToken(username, List.of("ROLE_WASHER"));
            return Mono.just(Map.of("token", "Bearer " + token));
        } else if ("user".equals(username) && "User@123".equals(password)) {
            String token = jwtTokenProvider.createToken(username, List.of("ROLE_USER"));
            return Mono.just(Map.of("token", "Bearer " + token));
        } else {
            return Mono.error(new RuntimeException("Invalid username or password"));
        }
    }
}
