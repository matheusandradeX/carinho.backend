package com.ifsp.hto.carinho.backend.resources;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.provider.HibernateUtils;
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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ifsp.hto.carinho.backend.dto.AlunoDTO;
import com.ifsp.hto.carinho.backend.dto.FrequenciaDTO;
import com.ifsp.hto.carinho.backend.dto.TurmaDTO;
import com.ifsp.hto.carinho.backend.model.Aluno;
import com.ifsp.hto.carinho.backend.model.AlunoResponsavel;
import com.ifsp.hto.carinho.backend.model.ControleAluno;
import com.ifsp.hto.carinho.backend.model.TipoGenero;
import com.ifsp.hto.carinho.backend.model.Turma;
import com.ifsp.hto.carinho.backend.repository.AlunoRepository;
import com.ifsp.hto.carinho.backend.repository.AlunoResponsavelRepository;
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

	@Autowired(required = true)
	AlunoResponsavelRepository alunoResponsavelRepository;
	
	
	
	
	
	
	@GetMapping("turma/{id}")
	public List<TurmaDTO> listaAlunos (@PathVariable(value = "id") long id){
		
		return alunoRepository.listaTurmas(id);
	}
	
	@GetMapping("frequencia/{id}")
	public List<FrequenciaDTO> listaFrequencia (@PathVariable(value = "id") long id){
		
		return alunoRepository.listaFrequencia(id);
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
	public String deletaAluno(@PathVariable(value = "id") long id) {
		ArrayList<ControleAluno> listaControleAluno = controleAlunoRepository.buscaFK(id);		
		for(ControleAluno elem : listaControleAluno){
		       System.out.println(elem.getId());
		       controleAlunoRepository.delete(elem);       
		}
		long a = alunoResponsavelRepository.aaa(id);
		alunoResponsavelRepository.deleteById(a);
		
		System.out.println(a);
		
	//alunoRepository.deleteById(id);
		
	deletaAlunoSemPai(id);
	
	return "deu certo";
	}
	
	
	public void deletaAlunoSemPai(long id) {
	
	alunoRepository.deleteById(id);
		
	
	}
	
	
	

	@DeleteMapping("/aluno")
	public void deletaAluno(@RequestBody Aluno aluno) {
		//alunoRepository.delete(aluno);
		//controleAlunoRepository.deleteById(null);
	}

	@PutMapping("/aluno")
public String salvaAlunos(int id_aluno,String nome, int idade, MultipartFile foto,int carteiraIdentidade, TipoGenero genero, int id_turma) throws IOException {
		
		//Turma turma2 = new Turma(numeroTurma, professorResponsavel);
		
		//Aluno aluno = new  Aluno(nome, idade, foto.getBytes(), carteiraIdentidade, genero,turma);
		//System.out.println(aluno);

		try { 
			
		Turma turma_teste = turmaRepository.findById(id_turma);	
			
		Aluno userFromDb = alunoRepository.findById(id_aluno);
	    userFromDb.setNome(nome);
	    userFromDb.setIdade(idade);
	    userFromDb.setCarteiraIdentidade(carteiraIdentidade);
	    userFromDb.setFoto(foto.getBytes());
	    userFromDb.setGenero(genero);
	    userFromDb.setTurma(turma_teste);  
	    
	    alunoRepository.save(userFromDb); 
	    
	    
	  
	    return "deu certo!";

			
		}catch(Exception e){
			   e.printStackTrace();
			   return "deu erro!";
			   
		}
	   
			
			
	
		
		
		
		//return alunoRepository.save(aluno);
		
		//return null;
		
	}


	
	

}
