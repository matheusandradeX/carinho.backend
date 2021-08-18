package com.ifsp.hto.carinho.backend.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ifsp.hto.carinho.backend.dto.ControleAlunoDTO;
import com.ifsp.hto.carinho.backend.model.Aluno;
import com.ifsp.hto.carinho.backend.model.ControleAluno;

public interface ControleAlunoRepository extends JpaRepository<ControleAluno,Long > {
	
	ControleAluno findById(long id);
	
	@Query(value = "SELECT * FROM controle_aluno", nativeQuery = true)
	List<ControleAlunoDTO> save2();

	
	
	@Query(value = "SELECT COUNT(tipo_horario) -1  FROM controle_aluno where fk_aluno = :id", nativeQuery = true)
	long cont(@Param("id")long id);
	
	@Query(value = "SELECT * FROM controle_aluno where fk_aluno =:id2 ORDER BY fk_aluno DESC LIMIT :numero ,1", nativeQuery = true)
	ControleAlunoDTO resultado(@Param("numero") long numero,@Param("id2") long id2);
	

	@Query(value = "SELECT * FROM `controle_aluno` WHERE fk_aluno = :id", nativeQuery = true)	
	ArrayList<ControleAluno> buscaFK(@Param("id")long id);
	
	

	

	
	
	
	
	
	
	

}
