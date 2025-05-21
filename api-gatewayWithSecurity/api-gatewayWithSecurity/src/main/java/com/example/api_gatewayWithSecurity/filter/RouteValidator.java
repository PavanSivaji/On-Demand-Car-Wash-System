package com.example.api_gatewayWithSecurity.filter;

import java.util.List;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

import com.example.api_gatewayWithSecurity.service.JwtService;

@Component
public class RouteValidator {
	@Autowired
	JwtService jwtservice;

	public static final List<String> openApiEndpoints=
			List.of(
					"/security/register",
					"/security/authenticate",
					"/auth/**",
					"/eureka"
					);
	public static final List<String> AdminApiEndpoints=
			List.of(
					"/admin/**",
					"/washer/**",
					"/user/**"
					);
	public static final List<String> WasherApiEndpoints=
			List.of(
					"/washer/**"
					);
	public static final List<String> UserApiEndpoints=
			List.of(
					"/user/**"
					);
	
	
	public Predicate<ServerHttpRequest> isSecured=
			request -> openApiEndpoints.stream()
			.noneMatch(uri->request.getURI().getPath().contains(uri));
			
			

	public Predicate<ServerHttpRequest> isAdminUri=
					(request) -> AdminApiEndpoints.stream()
					.anyMatch(uri->request.getURI().getPath().contains(uri));
	public Predicate<ServerHttpRequest> isUserUri=
							request -> UserApiEndpoints.stream()
							.anyMatch(uri->request.getURI().getPath().contains(uri));
    public Predicate<ServerHttpRequest> isWahserUri=
									request -> WasherApiEndpoints.stream()
									.anyMatch(uri->request.getURI().getPath().contains(uri));
	public boolean ValidateUsers(String token, ServerHttpRequest request) {
		String role=jwtservice.extractRole(token);
		if(isAdminUri.test(request) && role.equals("ROLE_ADMIN")) {
			return true;
		}
		if(isUserUri.test(request) && role.equals("ROLE_USER")) {
			return true;
		}
		if(isWahserUri.test(request) && role.equals("ROLE_WASHER")) {
			return true;
		}
		return false;
	}
							
	
			
}
