package com.iambstha.bTempJwt.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/api/v1/demo")
@RequiredArgsConstructor
@SecurityRequirement(name = "Bearer Authentication")
public class DemoController {

	
	@GetMapping("/user")
	@PreAuthorize("hasRole('ROLE_USER')")
	@Operation(summary = "Endpoint accessible only by users with the role 'ROLE_USER'")
	public ResponseEntity<String> sayHelloUser(Authentication auth) {
		return ResponseEntity.ok().body("Hello " + auth.getName() + " with authority " + auth.getAuthorities()
		+ " Principal" + auth.getPrincipal());
	}

	@GetMapping("/admin")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@Operation(summary = "Endpoint accessible only by users with the role 'ROLE_ADMIN'")
	public ResponseEntity<String> sayHelloAdmin(Authentication auth) {
		return ResponseEntity.ok().body("Hello " + auth.getName() + " with authority " + auth.getAuthorities()
		+ " Principal" + auth.getPrincipal());
	}
	

	@PreAuthorize("hasRole('ROLE_SUPER_ADMIN')")
	@Operation(summary = "Endpoint accessible only by users with the role 'ROLE_USER'")
	@GetMapping("/super-admin")
	public ResponseEntity<String> sayHelloSuperAdmin(Authentication auth) {
		return ResponseEntity.ok().body("Hello " + auth.getName() + " with authority " + auth.getAuthorities()
				+ " Principal" + auth.getPrincipal());
	}

}
