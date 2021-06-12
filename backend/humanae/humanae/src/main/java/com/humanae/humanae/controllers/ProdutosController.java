package com.humanae.humanae.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.humanae.humanae.models.Produtos;
import com.humanae.humanae.repositories.ProdutosRepository;

@RestController
@RequestMapping("/produtos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProdutosController {

	@Autowired
	private ProdutosRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Produtos>> findAllProdutos() {
		return ResponseEntity.status(200).body(repository.findAll()); 
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Produtos>> findByIdProdutos(@PathVariable long id) {
		return ResponseEntity.status(200).body(repository.findById(id));
	}
	 
	@GetMapping("/descricao/{descricao}")
	public ResponseEntity<List<Produtos>> findAllByDescricao(@PathVariable String descricao) {
		return ResponseEntity.status(200).body(repository.findAllByDescricaoContainingIgnoreCase(descricao));
	}
	 
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Produtos> postProdutos(@RequestBody Produtos produtos) {
		return ResponseEntity.status(201).body(repository.save(produtos));
	}
	
	@PutMapping
	public ResponseEntity<Produtos> putProdutos(@RequestParam Produtos produtos) {
		return ResponseEntity.status(200).body(repository.save(produtos));
	}
	
	@DeleteMapping("/{id}")
	public void deleteProdutos(@PathVariable long id) {
		repository.deleteById(id);
	}
}