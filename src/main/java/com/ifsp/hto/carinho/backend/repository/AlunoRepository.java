package com.ifsp.hto.carinho.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ifsp.hto.carinho.backend.dto.ResponsavelDTO;
import com.ifsp.hto.carinho.backend.dto.TesteDTO;
import com.ifsp.hto.carinho.backend.model.Aluno;


public interface AlunoRepository extends JpaRepository<Aluno, Long>{

	Aluno findById(long id);

	@Query(value = "SELECT * FROM `aluno` WHERE nome LIKE :nomeA%", nativeQuery = true)
	List<Aluno> findByNome (@Param("nomeA")String nome);
	
	@Query(value = "SELECT * from aluno INNER JOIN responsavel on aluno.id = responsavel.fk_responsavel_id", nativeQuery = true)
	List<Aluno> findByResponsavel();
	
	@Query(value ="SELECT responsavel.id,responsavel.carteira_identidade,responsavel.nome_resp from aluno_responsavel inner join aluno on aluno.id = aluno_responsavel.nome inner join responsavel on responsavel.id = aluno_responsavel.nome_resp WHERE aluno_responsavel.nome=:id", nativeQuery = true)
	List<ResponsavelDTO> responsavel(@Param("id")int id);

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@Query("SELECT new com.roytuts.spring.data.jpa.left.right.inner.cross.join.dto.DeptEmpDto(d.name, e.name, e.email, e.address) "
//			+ "FROM Department d LEFT JOIN d.employees e")
//	List<AlunoResponsavelDTO> fetchEmpDeptDataInnerJoin();
//	
	
	//@Query("select new package.DeadlineType(a.id, a.code) from ABDeadlineType a ")
	
	/*
	@Query(value ="SELECT aluno.id, aluno.nome, aluno.idade, responsavel.nome_resp, responsavel.data_nascimento from aluno INNER JOIN responsavel on aluno.id = responsavel.fk_aluno_id", nativeQuery = true)
	List<AlunoResponsavelDTO> teste();
	*/
	
//	@Query(value ="SELECT aluno.id, aluno.nome, aluno.idade, responsavel.nome_resp, responsavel.data_nascimento from aluno INNER JOIN responsavel on aluno.id = responsavel.fk_aluno_id", nativeQuery = true)
	@Query(value ="SELECT aluno_responsavel.id, aluno.nome, responsavel.nome_resp from aluno_responsavel inner join aluno on aluno.id = aluno_responsavel.nome inner join responsavel on responsavel.id = aluno_responsavel.nome_resp", nativeQuery = true)
	List<TesteDTO> teste();
	
	
	
	
	
	
	//SELECT aluno_responsavel.id, aluno.nome, responsavel.nome_resp from aluno_responsavel inner join aluno on aluno.id = aluno_responsavel.nome inner join responsavel on responsavel.id = aluno_responsavel.nome_resp
	
	@Query(value ="SELECT * FROM aluno", nativeQuery = true)
	List<Aluno> fetchEmpDeptDataInnerJoin2();
	
	
	
}
