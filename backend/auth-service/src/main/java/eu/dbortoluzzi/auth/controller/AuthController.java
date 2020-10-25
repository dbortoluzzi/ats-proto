package eu.dbortoluzzi.auth.controller;

import eu.dbortoluzzi.auth.model.User;
import eu.dbortoluzzi.auth.repository.UserAuthenticationService;
import eu.dbortoluzzi.auth.service.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.UNAUTHORIZED;

@RestController
public class AuthController {
	@Autowired
	private UserRegistrationService registrationService;
	@Autowired
	private UserAuthenticationService authenticationService;

	@PostMapping("/api/auth/register")
	public Object register(
			@RequestParam("username") String username,
			@RequestParam("password") String password) {
		try {
			return registrationService
					.register(username, password);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@PostMapping("/api/auth/login")
	public Object login(
			@RequestParam("username") String username,
			@RequestParam("password") String password) {
		try {
			return authenticationService
					.login(username, password);
		} catch (BadCredentialsException e) {
			return ResponseEntity.status(UNAUTHORIZED).body(e.getMessage());
		}
	}

	@GetMapping("/api/auth/auth")
	public Object auth(
			@RequestHeader("token") String token) {
		try {
			User user = authenticationService
					.authenticateByToken(token);
			return "Authorized";
		} catch (BadCredentialsException e) {
			return ResponseEntity.status(UNAUTHORIZED).body(e.getMessage());
		}
	}

}
