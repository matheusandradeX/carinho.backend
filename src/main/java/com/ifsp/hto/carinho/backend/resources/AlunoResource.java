package com.ifsp.hto.carinho.backend.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ifsp.hto.carinho.backend.model.Aluno;
import com.ifsp.hto.carinho.backend.repository.AlunoRepository;

@RestController
@RequestMapping(value ="/api")
@CrossOrigin(origins = "*")
public class AlunoResource {

	@Autowired(required = true)
	AlunoRepository alunoRepository;
	
	
	@GetMapping("alunos")
	public List<Aluno> listaAlunos(){
		return alunoRepository.findAll();
	}
	
	@GetMapping("aluno/{id}")
	public Aluno listaAlunoUnico(@PathVariable(value="id")long id) {
		return alunoRepository.findById(id);
	}
	
@GetMapping("alunos/{nome}")
public List<Aluno> listaNome(@PathVariable(value = "nome")String nome){
	return alunoRepository.findByNome(nome);
	
}
	
	
	
	
	
	
	@PostMapping("/aluno")
	public Aluno salvaAluno(@RequestBody Aluno aluno) {
		return alunoRepository.save(aluno);
	}
	
	@DeleteMapping("/aluno/{id}")
	public void deletaAluno(@PathVariable(value = "id") long id) {
		alunoRepository.delete(alunoRepository.findById(id));
	}
	@DeleteMapping("/aluno")
	public void deletaAluno(@RequestBody Aluno aluno) {
		alunoRepository.delete(aluno);
	}
	@PutMapping("/aluno")
	public Aluno atualizaAluno(@RequestBody Aluno aluno) {
		return alunoRepository.save(aluno);
	}
	
	
}
