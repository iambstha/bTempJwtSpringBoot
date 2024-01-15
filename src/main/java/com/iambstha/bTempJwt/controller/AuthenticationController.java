package com.iambstha.bTempJwt.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iambstha.bTempJwt.model.AuthenticationRequest;
import com.iambstha.bTempJwt.model.AuthenticationResponse;
import com.iambstha.bTempJwt.model.RegisterRequest;
import com.iambstha.bTempJwt.service.AuthenticationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthenticationController {

	private final AuthenticationService authenticationService;

	// Register a user
	@PostMapping(path = "/register", consumes = "application/json")
	public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request) {
		return ResponseEntity.ok(authenticationService.register(request));

	}

	// Authenticate a user
	@PostMapping(path = "/authenticate", consumes = "application/json")
	public ResponseEntity<AuthenticationResponse> register(@RequestBody AuthenticationRequest request) {
		return ResponseEntity.ok(authenticationService.authenticate(request));
	}

}
