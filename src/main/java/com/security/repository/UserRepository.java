package com.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.security.model.ApplicationUser;

public interface UserRepository extends JpaRepository<ApplicationUser, Integer>{

	Optional<ApplicationUser>findByUsername(String username);
	
}
