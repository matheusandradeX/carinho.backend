package com.ifsp.hto.carinho.backend.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ifsp.hto.carinho.backend.model.AlunoResponsavel;
import com.ifsp.hto.carinho.backend.model.ControleAluno;

public interface AlunoResponsavelRepository extends JpaRepository<AlunoResponsavel, Long>  {
	
	

	@Query(value ="SELECT * FROM `aluno_responsavel` WHERE `nome_resp`=:idResponsavel && `nome`=:idAluno",nativeQuery = true)
	AlunoResponsavel  selecionarResponsavel(@Param("idResponsavel") long idResponsavel,@Param("idAluno") long idAluno);
	
	
	@Query(value ="SELECT id from aluno_responsavel where nome = :idAluno and fk_escola = :idEscola",nativeQuery = true)
	ArrayList<Long> getIdRelacionamentoAluno(@Param("idAluno") long idAluno,@Param("idEscola") long idEscola);
	
	@Query(value ="SELECT id from aluno_responsavel where nome_resp = :idResponsavel and fk_escola = :idEscola",nativeQuery = true)
	ArrayList<Long> getIdRelacionamentoResponsavel(@Param("idResponsavel") long idResponsavel,@Param("idEscola") long idEscola);
	
	@Query(value = "SELECT * FROM `aluno_responsavel` WHERE nome = :id", nativeQuery = true)	
	ArrayList<AlunoResponsavel> getListaResponsaveis(@Param("id")long id);

}
