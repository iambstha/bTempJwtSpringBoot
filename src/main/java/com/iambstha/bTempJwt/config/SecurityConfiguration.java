package com.iambstha.bTempJwt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.iambstha.bTempJwt.filter.JwtAuthenticationFilter;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

	private final JwtAuthenticationFilter jwtAuthenticationFilter;

	private final AuthenticationProvider authenticationProvider;

	private static final String[] AUTH_WHITELIST = { "/api/v1/auth/**", "/api-docs/**", "/v2/api-docs",
			"/swagger-resources", "/swagger-resources/**", "/configuration/ui", "/configuration/security",
			"/swagger-ui.html", "/swagger-ui.html/**", "/webjars/**", "/v3/api-docs/**", "/swagger-ui/**" };

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		http.csrf(c -> c.disable()).authorizeHttpRequests(requests -> requests.requestMatchers(AUTH_WHITELIST)
				.permitAll()
				.requestMatchers("/api/v1/demo/user").hasRole("USER")
				.requestMatchers("/api/v1/demo/admin").hasRole("ADMIN")
				.requestMatchers("/api/v1/demo/super-admin").hasRole("SUPER_ADMIN")
				.anyRequest().authenticated())
				.sessionManagement(management -> management.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.authenticationProvider(authenticationProvider)
				.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

		return http.build();
	}

}
