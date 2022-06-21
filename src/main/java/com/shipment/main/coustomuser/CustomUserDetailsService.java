package com.shipment.main.coustomuser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.shipment.main.entity.User;
import com.shipment.main.repository.UserRepository;

public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		
		User user = userRepository.findByUserId(userId);
		
		if(user == null) {
			throw new UsernameNotFoundException("User Not Fount");
		}
		return new CustomUserDetails(user);
	}

}
