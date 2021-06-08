package com.humanae.humanae.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.humanae.humanae.models.Usuario;

public interface UsuarioRepository  extends JpaRepository<Usuario, Long>{
	
	public Optional<Usuario> findByEmail(String email);

}
