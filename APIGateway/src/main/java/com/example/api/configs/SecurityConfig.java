package com.example.api.configs;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.web.server.SecurityWebFilterChain;

import com.example.api.filters.JwtAuthenticationFilter;

@Configuration
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    public SecurityConfig(JwtAuthenticationFilter jwtAuthenticationFilter) {
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
    }

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        return http
            .csrf(ServerHttpSecurity.CsrfSpec::disable)
            .authorizeExchange(exchange -> exchange
               
                .pathMatchers("/auth/**").permitAll() 

                // Roles-based access for specific routes
                .pathMatchers("/auth/**").permitAll()
                .pathMatchers("/admin/**").hasAnyAuthority("ROLE_ADMIN","ROLE_USER","ROLE_WASHER")  // Only admin can access /admin
                .pathMatchers("/washer/**").hasAnyAuthority("ROLL_WASHER","ROLE_ADMIN")  // Only washer can access /washer
                .pathMatchers("/user/**").hasAnyAuthority("ROLL_USER","ROLE_ADMIN")  // Only user can access /user

                // Default: All other paths must be authenticated
                .anyExchange().authenticated()  
            )
            .addFilterAt(jwtAuthenticationFilter, SecurityWebFiltersOrder.AUTHENTICATION) // Add JWT filter
            .build();
    }

    @Bean
    public MapReactiveUserDetailsService userDetailsService() {
        UserDetails admin = User.withUsername("admin")
            .password("{noop}Admin@123") // Plain password (use bcrypt in production)
            .roles("ADMIN")  // The role "ROLE_ADMIN" will be used internally by Spring Security
            .build();

        UserDetails washer = User.withUsername("washer")
            .password("{noop}Washer@123")
            .roles("WASHER")  // The role "ROLE_WASHER" will be used internally by Spring Security
            .build();

        UserDetails user = User.withUsername("user")
            .password("{noop}User@123")
            .roles("USER")  // The role "ROLE_USER" will be used internally by Spring Security
            .build();

        return new MapReactiveUserDetailsService(admin, washer, user);
    }
}

