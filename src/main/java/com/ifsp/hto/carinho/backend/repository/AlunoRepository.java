package com.ifsp.hto.carinho.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ifsp.hto.carinho.backend.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long>{

	Aluno findById(long id);

	@Query(value = "SELECT * FROM `aluno` WHERE nome LIKE :nomeA%", nativeQuery = true)
	List<Aluno> findByNome (@Param("nomeA")String nome);

	Aluno foto(byte[] arquivo);
}
