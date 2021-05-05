  
package com.humanae.humanae.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.humanae.humanae.models.Parceiros;
import com.humanae.humanae.models.Produtos;
import com.humanae.humanae.repositories.ParceirosRepository;

@RestController
@RequestMapping("/parceiros")
public class ParceirosController {

	private ParceirosRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Parceiros>> findAllParceiros() {
		return ResponseEntity.status(200).body(repository.findAll()); 
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Parceiros>> findByIdParceiros(@PathVariable long id) {
		return ResponseEntity.status(200).body(repository.findById(id));
	}
	 
	@GetMapping("/descricao/{descricao}")
	public ResponseEntity<List<Parceiros>> findAllByDescricao(@PathVariable String descricao) {
		return ResponseEntity.status(200).body(repository.findAllByCausaContainingIgnoreCase(descricao));
	}
	 
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Parceiros> postParceiros(@RequestBody Parceiros parceiros) {
		return ResponseEntity.status(201).body(repository.save(parceiros));
	}
	
	@PutMapping
	public ResponseEntity<Parceiros> putParceiros(@RequestParam Parceiros parceiros) {
		return ResponseEntity.status(200).body(repository.save(parceiros));
	}
	
	@DeleteMapping("/{id}")
	public void deleteParceiros(@PathVariable long id) {
		repository.deleteById(id);
	}
}
