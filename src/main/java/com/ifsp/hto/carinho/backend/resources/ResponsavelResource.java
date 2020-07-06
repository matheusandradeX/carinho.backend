package com.ifsp.hto.carinho.backend.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ifsp.hto.carinho.backend.dto.ResponsavelDTO;
import com.ifsp.hto.carinho.backend.repository.ResponsavelRepository;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
public class ResponsavelResource {

	@Autowired(required = true)
	ResponsavelRepository responsavelRepository;
	
	@GetMapping("responsavel/{id}")
	public List<ResponsavelDTO> responsavel(@PathVariable(value = "id") int id) {
		return responsavelRepository.responsavel(id);
	}
	
	
	
	
	
	
	
	
}
