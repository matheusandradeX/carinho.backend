package com.ifsp.hto.carinho.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ifsp.hto.carinho.backend.dto.TurmaDTO;
import com.ifsp.hto.carinho.backend.model.Turma;

public interface TurmaRepository extends JpaRepository<Turma, Long > {
	
	Turma findById(long id);

	

	@Query(value= "select * from turma WHERE fk_escola =:idEscola",nativeQuery = true)
	List<Turma>  listaTurmas(@Param("idEscola") long idEscola) ;
	
	
}
