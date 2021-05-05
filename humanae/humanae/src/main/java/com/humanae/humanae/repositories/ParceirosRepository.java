package com.humanae.humanae.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.humanae.humanae.models.Parceiros;

@Repository
public interface ParceirosRepository extends JpaRepository<Parceiros, Long>{

	public List<Parceiros> findByCausaContainingIgnoreCase(String descricao);
}
