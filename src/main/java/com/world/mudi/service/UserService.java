package com.world.mudi.service;

import com.world.mudi.security.ImplementsUserDetails;
import com.world.mudi.model.UserModel;
import com.world.mudi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	public UserModel registerUser(UserModel userModel) {
		userModel.setPassword(this.passwordEncoder().encode(userModel.getPassword()));
		return userRepository.save(userModel);
	}

	@Override
	public ImplementsUserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		UserModel user = userRepository.findByUsername(username);
		return new ImplementsUserDetails(user);
	}
}
