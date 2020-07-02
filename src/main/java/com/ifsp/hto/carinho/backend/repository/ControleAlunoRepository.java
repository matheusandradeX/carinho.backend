package com.ifsp.hto.carinho.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ifsp.hto.carinho.backend.dto.ControleAlunoDTO;
import com.ifsp.hto.carinho.backend.model.Aluno;
import com.ifsp.hto.carinho.backend.model.ControleAluno;

public interface ControleAlunoRepository extends JpaRepository<ControleAluno,Long > {

	
	@Query(value = "SELECT * FROM controle_aluno", nativeQuery = true)
	List<ControleAlunoDTO> save2();
	
	
	
	
	//public Soldado buscarPorNumero(int num){ return this.sdRepo.findByNumero(num); }
	
	//public boolean existePorNumero(int num){ return this.sdRepo.existsByNumero(num); }

}
