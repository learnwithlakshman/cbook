package com.lwl.cbook.auth;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AppUserDetailsService implements UserDetailsService {
	
	private  BCryptPasswordEncoder bCryptPasswordEncoder;
	Map<String, UserDetails> map;

	@Autowired
	public AppUserDetailsService(BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
		map = new HashMap<>();
		UserDetails user1 = User.builder().username("user").password(this.bCryptPasswordEncoder.encode("userpwd"))
				.roles("USER").build();
		UserDetails user2 = User.builder().username("admin").password(this.bCryptPasswordEncoder.encode("adminpwd"))
				.roles("ADMIN").build();
		map.put("user", user1);
		map.put("admin", user2);

	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return Optional.of(map.get(username)).map(e ->e)
				.orElseThrow(() -> new UsernameNotFoundException("User not found with given name"));
	}

}
