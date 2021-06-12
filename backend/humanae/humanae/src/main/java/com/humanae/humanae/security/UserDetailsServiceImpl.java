package com.humanae.humanae.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.humanae.humanae.models.Usuario;
import com.humanae.humanae.repositories.UsuarioRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UsuarioRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
		
		Optional<Usuario> user = userRepository.findByEmail(userEmail);
		user.orElseThrow(() -> new UsernameNotFoundException( userEmail + " Not found "));
		return user.map(UserDetailsImpl::new).get();
	}

}
