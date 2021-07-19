package com.ifsp.hto.carinho.backend.resources;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ifsp.hto.carinho.backend.dto.AlunoDTO;
import com.ifsp.hto.carinho.backend.dto.TurmaDTO;
import com.ifsp.hto.carinho.backend.model.Aluno;
import com.ifsp.hto.carinho.backend.model.TipoGenero;
import com.ifsp.hto.carinho.backend.model.Turma;
import com.ifsp.hto.carinho.backend.repository.AlunoRepository;
import com.ifsp.hto.carinho.backend.repository.ControleAlunoRepository;
import com.ifsp.hto.carinho.backend.repository.TurmaRepository;
import com.ifsp.hto.carinho.backend.wrapper.FormWrapper;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
public class AlunoResource {

	@Autowired(required = true)
	AlunoRepository alunoRepository;
	@Autowired(required = true)
	TurmaRepository turmaRepository;
	
	@Autowired(required = true)
	ControleAlunoRepository controleAlunoRepository;
	
	
	@GetMapping("/turma/{id}")
	public List<TurmaDTO> listaAlunos (@PathVariable(value = "id") long id){
		
		return alunoRepository.listaTurmas(id);
	}
	
	
	

	@GetMapping("alunos")
	public List<Aluno> listaAlunos() {
		return alunoRepository.findAll();
	}

	
	@GetMapping("aluno/{id}")
	public Aluno listaAlunoUnico(@PathVariable(value = "id") long id) {
		return alunoRepository.findById(id);
	}

	@GetMapping("alunos/{nome}")
	public List<Aluno> listaNome(@PathVariable(value = "nome") String nome) {
		return alunoRepository.findByNome(nome);

	}

	@GetMapping("/testeAluno")
	public List<AlunoDTO> listaTeste() {
		return alunoRepository.todosAlunos(alunoRepository.count());
	}

	@PostMapping("/aluno")
	public Aluno salvaAluno( String nome, int idade, MultipartFile foto,int carteiraIdentidade, TipoGenero genero, long turma) throws IOException {
		System.out.println("---------------");
		System.out.println(turma);
		//return null;
		
		Turma t = turmaRepository.findById(turma);	
		
		
		foto.getBytes();	
		Aluno aluno = new  Aluno(nome, idade, foto.getBytes(), carteiraIdentidade, genero,t);
		System.out.println(aluno);
		return alunoRepository.save(aluno);
		
	}

	@DeleteMapping("/aluno/{id}")
	public void deletaAluno(@PathVariable(value = "id") long id) {
		alunoRepository.delete(alunoRepository.findById(id));
		controleAlunoRepository.deleteById(controleAlunoRepository.findById(id));
	}

	@DeleteMapping("/aluno")
	public void deletaAluno(@RequestBody Aluno aluno) {
		//alunoRepository.delete(aluno);
		//controleAlunoRepository.deleteById(null);
	}

	@PutMapping("/aluno")
	public Aluno salvaAlunos(String nome, int idade, MultipartFile foto,int carteiraIdentidade, TipoGenero genero, Turma  turma) throws IOException {
		
		
		
		
		foto.getBytes();	
		Aluno aluno = new  Aluno(nome, idade, foto.getBytes(), carteiraIdentidade, genero,turma);
		System.out.println(aluno);
		return alunoRepository.save(aluno);
		
	}


	
	

}
