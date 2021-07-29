package com.ifsp.hto.carinho.backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ifsp.hto.carinho.backend.dto.ControleAlunoDTO;
import com.ifsp.hto.carinho.backend.model.Aluno;
import com.ifsp.hto.carinho.backend.model.ControleAluno;

public interface ControleAlunoRepository extends JpaRepository<ControleAluno,Long > {

	
	@Query(value = "SELECT * FROM controle_aluno", nativeQuery = true)
	List<ControleAlunoDTO> save2();

	void deleteById(Optional<ControleAluno> findById);
	
	
	
	@Query(value = "SELECT COUNT(tipo_horario) -1  FROM controle_aluno where fk_aluno = 19", nativeQuery = true)
	int teste1();
	
	
	
	@Query(value = "SELECT tipo_horario FROM controle_aluno where fk_aluno =19 ORDER BY fk_aluno DESC LIMIT :numero ,1", nativeQuery = true)
	String teste2(@Param("numero") long id);
	
	
	
	
	//public Soldado buscarPorNumero(int num){ return this.sdRepo.findByNumero(num); }
	
	//public boolean existePorNumero(int num){ return this.sdRepo.existsByNumero(num); }

}
