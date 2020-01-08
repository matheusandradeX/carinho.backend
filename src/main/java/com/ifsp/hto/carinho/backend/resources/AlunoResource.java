package com.ifsp.hto.carinho.backend.resources;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ifsp.hto.carinho.backend.model.Aluno;
import com.ifsp.hto.carinho.backend.model.FormWrapper;
import com.ifsp.hto.carinho.backend.repository.AlunoRepository;
import com.ifsp.hto.carinho.backend.util.Disco;

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


/*
	@PostMapping(consumes = "multipart/form-data")
	public Aluno upload(@RequestBody Aluno alunoNovo ,MultipartFile foto) {
		
		byte[] arquivo ; 
		
		try {
			arquivo = foto.getBytes();
			
			Aluno teste = new Aluno(alunoNovo.getNome(),alunoNovo.getIdade(),alunoNovo.getSexo(),alunoNovo.getCarteiraIdentidade(),arquivo);
			return alunoRepository.save(teste);
		} catch (Exception e) {
			throw new RuntimeException("Problemas na tentativa de salvar arquivo.", e);
		}
		
	*/


@PostMapping
	public void upload (@ModelAttribute FormWrapper modelo) {
	try {
		
		Aluno novoAluno = new Aluno (modelo.getNome(),modelo.getIdade(), modelo.getSexo(), modelo.getCarteiraIdentidade(),modelo.getImage().getBytes());
		alunoRepository.save(novoAluno);
	} catch (Exception e) {
		throw new RuntimeException("Problemas em salvar o Aluno.", e);
	}

	}


	 










}
