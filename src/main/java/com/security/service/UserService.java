package com.security.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.security.model.ApplicationUser;
import com.security.model.Role;
import com.security.repository.UserRepository;

@Service
public class UserService implements UserDetailsService{

	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("In tis user details service");
		
		//Before Connect Dastabase coded
		
//		if(!username.equals("lucky"))throw new UsernameNotFoundException("not Ethan");
//		Set<Role>role=new HashSet<>();
//		role.add(new Role(1,"USER"));
//		return new ApplicationUser(1, "lucky",encoder.encode("Shravan"), role);
	
	return userRepository.findByUsername(username).orElseThrow(()->new UsernameNotFoundException("User Not Found"));
	}
	
	

}
