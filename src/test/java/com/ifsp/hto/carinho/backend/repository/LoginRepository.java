package com.ifsp.hto.carinho.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ifsp.hto.carinho.backend.model.Login;

public interface LoginRepository extends JpaRepository<Login, Long> {

	Login findById(long id);
	
	@Query(value = "SELECT * FROM login WHERE usuario =:id  AND senha =:id2 and fk_escola =:idEscola",nativeQuery = true)
	Login validarUsuario(@Param("id") String nome,@Param("id2") String senha,@Param("idEscola") long idEscola);
	
	@Query(value= "SELECT * FROM `login` WHERE `perfil` = 'PROFESSOR' ",nativeQuery = true)
	List<Login>  professoresCadastrados();

	
}
