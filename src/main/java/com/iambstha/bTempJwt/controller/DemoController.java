package com.iambstha.bTempJwt.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
	public ResponseEntity<String> sayHelloUser() {
		return ResponseEntity.ok("Hello user");
	}

	@GetMapping("/admin")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@Operation(summary = "Endpoint accessible only by users with the role 'ROLE_ADMIN'")
	public ResponseEntity<String> sayHelloAdmin() {
		return ResponseEntity.ok("Hello admin");
	}

}
