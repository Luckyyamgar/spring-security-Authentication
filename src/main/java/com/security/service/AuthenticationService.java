package com.security.service;

import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.security.model.ApplicationUser;
import com.security.model.LoginResponceDTO;
import com.security.model.Role;
import com.security.repository.RoleRepository;
import com.security.repository.UserRepository;

import jakarta.transaction.Transactional;
@Service
@Transactional
public class AuthenticationService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	
	private PasswordEncoder passwordEncoder;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private TokenService tokenService;

	public ApplicationUser registerUser(String username, String password) {
		String encodedPassword = passwordEncoder.encode(password);

		Role userRole = roleRepository.findByAuthority("ADMIN").get();

		Set<Role> authority = new HashSet<>();

		authority.add(userRole);

		return userRepository.save(new ApplicationUser(0, username, encodedPassword, authority));

	}

	public LoginResponceDTO loginUser(String username, String password) {
		// try {
		Authentication auth = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		String token = ((TokenService) tokenService).generateJwt(auth);

		return new LoginResponceDTO(userRepository.findByUsername(username).get(), token);

//		}catch(AuthenticationException e) {
//			return new LoginResponceDTO(null,"");
//			
//		}

	}
}
