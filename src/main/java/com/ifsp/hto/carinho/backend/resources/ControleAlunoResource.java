package com.ifsp.hto.carinho.backend.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ifsp.hto.carinho.backend.model.ControleAluno;
import com.ifsp.hto.carinho.backend.repository.AlunoRepository;
import com.ifsp.hto.carinho.backend.repository.ControleAlunoRepository;
import com.ifsp.hto.carinho.backend.util.Utility;
import com.ifsp.hto.carinho.backend.wrapper.ControleAlunoWrapper;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
public class ControleAlunoResource {

	@Autowired(required = true)
	AlunoRepository alunoRepository;

	@Autowired(required = true)
	ControleAlunoRepository controleAlunoRepository;

	@PostMapping("/controle")
	public ControleAluno lista(@RequestBody ControleAlunoWrapper controleAlunoWrapper) {
	
	//public String lista(@RequestBody ControleAlunoWrapper controleAlunoWrapper) {
		
		System.out.println("-------------------------------");
		System.out.println(controleAlunoWrapper);
		System.out.println(controleAlunoWrapper.getId());
		System.out.println(controleAlunoWrapper.getTipoHorario());

		

		ControleAluno controleAluno = new ControleAluno(
				Utility.getDate("Brazil/East"),
				controleAlunoWrapper.getTipoHorario(), 
				alunoRepository.findById(controleAlunoWrapper.getId())
				);
		
		
		return controleAlunoRepository.save(controleAluno);
		
		
		
		
		
		
		//return "deu certo";

	}

	@GetMapping("/controle")
	public ResponseEntity<List<ControleAluno>> listaHorario() {

		return new ResponseEntity<>(controleAlunoRepository.findAll(), HttpStatus.OK);

	}
	
	@GetMapping("/f")
	public String FFFF() {

		
		
		int cont = controleAlunoRepository.teste1();
		String d = controleAlunoRepository.teste2(cont);
		
		
	
		
		return d;

	}

}
