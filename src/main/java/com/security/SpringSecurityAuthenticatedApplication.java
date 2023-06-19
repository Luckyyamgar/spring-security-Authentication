package com.security;

import java.util.HashSet;

import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.security.model.ApplicationUser;
import com.security.model.Role;
import com.security.repository.RoleRepository;
import com.security.repository.UserRepository;
import com.security.service.AuthenticationService;

@SpringBootApplication
@ComponentScan(basePackages = "com.security.service")
@ComponentScan(basePackageClasses = AuthenticationService.class)
public class SpringSecurityAuthenticatedApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityAuthenticatedApplication.class, args);
	}

	

	@Bean
	CommandLineRunner run(RoleRepository roleRepository, UserRepository userRepository, PasswordEncoder passwordEncode){
		return args ->{
			if(roleRepository.findByAuthority("ADMIN").isPresent()) return;
			Role adminRole = roleRepository.save(new Role("ADMIN"));
			roleRepository.save(new Role("USER"));
			roleRepository.save(new Role("EMPLOYEE"));
			roleRepository.save(new Role("MANAGER"));

			Set<Role> roles = new HashSet<>();
			roles.add(adminRole);

			ApplicationUser admin = new ApplicationUser(1, "admin", passwordEncode.encode("password"), roles);

			userRepository.save(admin);
			
			
		};
	}
}
