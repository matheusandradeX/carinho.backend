package com.ifsp.hto.carinho.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ifsp.hto.carinho.backend.model.Turma;

public interface TurmaRepository extends JpaRepository<Turma, Long > {
	
	Turma findById(long id);

	

	
	
	
}
