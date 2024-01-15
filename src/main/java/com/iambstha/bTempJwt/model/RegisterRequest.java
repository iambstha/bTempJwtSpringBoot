package com.iambstha.bTempJwt.model;

import com.iambstha.bTempJwt.enums.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterRequest {

	private String firstname;

	private String lastname;

	private String username;

	private String password;
	
	private Role role;

}
