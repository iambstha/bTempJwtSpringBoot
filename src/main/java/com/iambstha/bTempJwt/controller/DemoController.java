package com.iambstha.bTempJwt.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/demo")
public class DemoController {

	@GetMapping("/user")
	public ResponseEntity<String> sayHelloUser() {
		return ResponseEntity.ok("Hello user");
	}

	@GetMapping("/admin")
	public ResponseEntity<String> sayHelloAdmin() {
		return ResponseEntity.ok("Hello admin");
	}

}
