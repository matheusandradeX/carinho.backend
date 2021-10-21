package com.ifsp.hto.carinho.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ifsp.hto.carinho.backend.model.Aluno;
import com.ifsp.hto.carinho.backend.model.AlunoControleAluno;
import com.ifsp.hto.carinho.backend.model.AlunoResponsavel;
import com.ifsp.hto.carinho.backend.model.Login;



public interface AlunoControleAlunoRepository extends JpaRepository<AlunoControleAluno, Long> {
	
	
	
	@Query(value ="select * from aluno_controle_aluno where aluno_id =:id",nativeQuery = true)
	List<AlunoControleAluno> getAlunoControleAlunoByIdList(long id);
	

	
	@Query(value ="SELECT DISTINCT aluno_id FROM aluno_controle_aluno",nativeQuery = true)
	List<Long> getAllId();
	
	
	@Query(value ="SELECT DISTINCT aluno_id FROM aluno_controle_aluno INNER JOIN aluno on aluno_id=aluno.id where aluno.nome LIKE :nomeA% and aluno.fk_escola = :idEscola ",nativeQuery = true)
	List<Long> findByNome(@Param("nomeA") String nome,@Param("idEscola") long idEscola);

	
	
	@Query(value ="SELECT * FROM `aluno_controle_aluno` WHERE aluno_id =:id order by controle_aluno_id DESC LIMIT 1",nativeQuery = true)
	AlunoControleAluno eee(long id);
	
	
	@Query(value ="SELECT * FROM `aluno_controle_aluno` WHERE `aluno_id` =:idAluno and `fk_escola` =:idEscola ORDER by `controle_aluno_id` DESC LIMIT 1", nativeQuery = true)
	AlunoControleAluno findByidControleAluno(@Param("idAluno") long idAluno,@Param("idEscola") long idEscola);

	

}