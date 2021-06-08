package com.humanae.humanae.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.humanae.humanae.models.UserLogin;
import com.humanae.humanae.models.Usuario;
import com.humanae.humanae.repositories.UsuarioRepository;
import com.humanae.humanae.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin("*")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private UsuarioRepository repository;
	
	@PostMapping("/logar")
	public ResponseEntity<UserLogin> autenticar(@RequestBody Optional<UserLogin> user){
		return usuarioService.logar(user).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Optional<Usuario>> cadastrar(@RequestBody Usuario usuario){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(usuarioService.cadastrarUsuario(usuario));
	}
	
	@GetMapping
	public ResponseEntity<List<Usuario>> findAllUsuario() {
		return ResponseEntity.status(200).body(repository.findAll()); 
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Usuario>> findByIdUsuario(@PathVariable long id) {
		return ResponseEntity.status(200).body(repository.findById(id));
	}
	 
	/*
	 * @GetMapping("/descricao/{descricao}") public ResponseEntity<List<Usuario>>
	 * findAllByDescricao(@PathVariable String descricao) { return
	 * ResponseEntity.status(200).body(repository.findAllByCausaContainingIgnoreCase
	 * (descricao)); }
	 */
	 	
	@PutMapping
	public ResponseEntity<Usuario> put(@RequestParam Usuario usuario) {
		return ResponseEntity.status(200).body(repository.save(usuario));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}
}



