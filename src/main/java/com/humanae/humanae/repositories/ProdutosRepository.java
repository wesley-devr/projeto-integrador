package com.humanae.humanae.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.humanae.humanae.models.Produtos;

public interface ProdutosRepository extends JpaRepository<Produtos, Long> {

	public List<Produtos> findAllByDescricaoContainingIgnoreCase(String descricao);
}