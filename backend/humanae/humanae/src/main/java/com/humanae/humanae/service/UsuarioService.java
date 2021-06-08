package com.humanae.humanae.service;

import java.nio.charset.Charset;
import java.util.Optional;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.humanae.humanae.models.UserLogin;
import com.humanae.humanae.models.Usuario;
import com.humanae.humanae.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;
	
	public Optional<Usuario> cadastrarUsuario (Usuario usuarioNovo){
		Optional<Usuario> usuarioExistente = repository.findByEmail(usuarioNovo.getEmail());
		if (usuarioExistente.isPresent()) {
			return Optional.empty();
		} else {
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			String senhaCriptogra = encoder.encode(usuarioNovo.getSenha());
			usuarioNovo.setSenha(senhaCriptogra);
			return Optional.ofNullable(repository.save(usuarioNovo));

		}
	}
	
	public Optional<UserLogin> logar(Optional<UserLogin> user){
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Optional<Usuario> usuario = repository.findByEmail(user.get().getEmail());
		
		if(usuario.isPresent()) {
			if(encoder.matches(user.get().getSenha(), usuario.get().getSenha())) {
				
				String auth = user.get().getEmail() + ":" + user.get().getSenha();
				byte[] encodeAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
				String authHeader = "Basic " + new String(encodeAuth);
				
				user.get().setToken(authHeader);
				user.get().setNome(usuario.get().getNome());
				user.get().setTipoDoador(usuario.get().isTipoDoador());
				user.get().setTipoParceiros(usuario.get().isTipoParceiros());
				
				return user;
			}
		}
		
		return null;
	}
	
}
	


