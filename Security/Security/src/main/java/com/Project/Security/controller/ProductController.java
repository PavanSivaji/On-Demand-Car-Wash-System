package com.Project.Security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import com.Project.Security.dto.AuthRequest;
import com.Project.Security.entity.UserInfo;
import com.Project.Security.service.JwtService;
import com.Project.Security.service.ProductService;

@RestController
@RequestMapping("/security")
public class ProductController {

    @Autowired
    private ProductService service;
    
    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    // Register new user
    @PostMapping("/register")
    public String addNewUser(@RequestBody UserInfo userInfo) {
        return service.addUser(userInfo);
    }

//    // Admin endpoint (Restricted)
//    @GetMapping("/admin")
//    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
//    public String getAllTheProducts() {
//        return "Welcome Admin!";
//    }
//
//    // User endpoint (Restricted) - Fetch product by ID
//    @GetMapping("/user/{id}")
//    @PreAuthorize("hasAuthority('ROLE_USER')")
//    public String getProductById(@PathVariable int id) {
//        return "Welcome User! You requested product ID: " + id;
//    }

    // Authenticate and return JWT token with role
    @PostMapping("/authenticate")
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
        );

        if (authentication.isAuthenticated()) {
            // Fetch user details from database
            UserInfo user = service.getUserByUsername(authRequest.getUsername());

            // Generate JWT with role
            return jwtService.generateToken(authRequest.getUsername(), user.getRoles());
        } else {
            throw new UsernameNotFoundException("Invalid user request! Authentication failed.");
        }
    }
}