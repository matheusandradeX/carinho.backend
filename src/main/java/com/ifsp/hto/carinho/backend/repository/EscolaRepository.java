package com.ifsp.hto.carinho.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ifsp.hto.carinho.backend.model.Escola;
import com.ifsp.hto.carinho.backend.model.Turma;

public interface EscolaRepository extends  JpaRepository<Escola, Long>{

	

	Escola findById(long id);
	
}
