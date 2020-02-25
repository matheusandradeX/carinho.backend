package com.ifsp.hto.carinho.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ifsp.hto.carinho.backend.model.Login;

public interface LoginRepository extends JpaRepository<Login, Long> {

	
		Login findById(long id);
}
