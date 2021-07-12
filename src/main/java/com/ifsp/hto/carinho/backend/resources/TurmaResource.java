package com.ifsp.hto.carinho.backend.resources;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ifsp.hto.carinho.backend.model.Login;
import com.ifsp.hto.carinho.backend.model.Responsavel;
import com.ifsp.hto.carinho.backend.model.TipoUsuario;
import com.ifsp.hto.carinho.backend.model.Turma;
import com.ifsp.hto.carinho.backend.repository.TurmaRepository;
import com.ifsp.hto.carinho.backend.util.MD5;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
public class TurmaResource {

	@Autowired(required = true)
	TurmaRepository turmaRepository;
	
	
	@GetMapping("/turmas")
	public List<Turma> lista (){
		
		return turmaRepository.findAll();
	}
	
	@PostMapping("/cadastrarTurma")
	public Turma  cadastro(String numeroTurma, String professorResponsavel){
		
		Turma turma = new Turma(numeroTurma,professorResponsavel);
		return turmaRepository.save(turma);
				
	}
	
	
	
	
	
	
}
