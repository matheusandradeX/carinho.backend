package com.ifsp.hto.carinho.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ifsp.hto.carinho.backend.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long>{

		Aluno findById(long id);
}
