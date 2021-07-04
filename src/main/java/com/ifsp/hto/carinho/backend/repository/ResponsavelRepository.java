package com.ifsp.hto.carinho.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ifsp.hto.carinho.backend.dto.AlunoDTO;
import com.ifsp.hto.carinho.backend.dto.ResponsavelDTO;
import com.ifsp.hto.carinho.backend.model.AlunoResponsavel;
import com.ifsp.hto.carinho.backend.model.Responsavel;

public interface ResponsavelRepository extends JpaRepository<Responsavel, Long> {

	Responsavel findById(long id);
	
	
	
	@Query(value = "SELECT responsavel.telefone, responsavel.foto,responsavel.id,responsavel.carteira_identidade,responsavel.nome_resp,responsavel.tipo_responsavel from aluno_responsavel inner join aluno on aluno.id = aluno_responsavel.nome inner join responsavel on responsavel.id = aluno_responsavel.nome_resp WHERE aluno_responsavel.nome=:id", nativeQuery = true)
	List<ResponsavelDTO> responsavel(@Param("id") int id);

	
	@Query(value = "SELECT `id` FROM `aluno_responsavel` WHERE `nome_resp`=:id",nativeQuery = true)
	List<Integer>  selecionarResponsavel(@Param("id") long id);
	
	
}
