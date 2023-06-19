package com.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.model.ApplicationUser;
import com.security.model.LoginResponceDTO;
import com.security.model.ResgistrationDTO;
import com.security.service.AuthenticationService;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthenticatonController {

	@Autowired
	private AuthenticationService authenticationService;
	
	@PostMapping("/register")
	public ApplicationUser registerUser(@RequestBody ResgistrationDTO register) {
		return authenticationService.registerUser(register.getUsername(), register.getPassword());
	}
	@PostMapping("/login")
	public LoginResponceDTO loginUser(@RequestBody ResgistrationDTO register) {
		return authenticationService.loginUser(register.getUsername(), register.getPassword());
	}
}
