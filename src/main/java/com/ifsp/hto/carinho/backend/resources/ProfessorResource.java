package com.ifsp.hto.carinho.backend.resources;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ifsp.hto.carinho.backend.model.Professor;
import com.ifsp.hto.carinho.backend.model.Responsavel;
import com.ifsp.hto.carinho.backend.model.TipoResponsavel;
import com.ifsp.hto.carinho.backend.repository.ProfessorRepository;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
public class ProfessorResource {

	
	@Autowired(required = true)
	ProfessorRepository professorRepository;
	
	@GetMapping("/professores")
	public List<Professor> teste (){
		
	return professorRepository.findAll();
	}
	@PostMapping("/professor") 
	public Professor salva(String nome, String turma )  {
		
	Professor professor = new Professor(nome,turma);
			
	return professorRepository.save(professor);
	
	}
	
}
