package com.ifsp.hto.carinho.backend.resources;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import javax.sql.rowset.serial.SerialBlob;

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
import com.ifsp.hto.carinho.backend.model.AlunoControleAluno;
import com.ifsp.hto.carinho.backend.model.AlunoResponsavel;
import com.ifsp.hto.carinho.backend.model.ControleAluno;
import com.ifsp.hto.carinho.backend.model.Escola;
import com.ifsp.hto.carinho.backend.model.TipoGenero;
import com.ifsp.hto.carinho.backend.model.TipoHorario;
import com.ifsp.hto.carinho.backend.model.Turma;
import com.ifsp.hto.carinho.backend.repository.AlunoControleAlunoRepository;
import com.ifsp.hto.carinho.backend.repository.AlunoRepository;
import com.ifsp.hto.carinho.backend.repository.AlunoResponsavelRepository;
import com.ifsp.hto.carinho.backend.repository.ControleAlunoRepository;
import com.ifsp.hto.carinho.backend.repository.EscolaRepository;
import com.ifsp.hto.carinho.backend.repository.TurmaRepository;
import com.ifsp.hto.carinho.backend.wrapper.FormWrapper;
import com.mysql.cj.jdbc.Blob;

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
	AlunoControleAlunoRepository alunoControleAlunoRepository;
	
	@Autowired(required = true)
	AlunoResponsavelRepository alunoResponsavelRepository;
	
	@Autowired(required = true)
	EscolaRepository escolaRepository;
	

	
	@GetMapping("frequencia/{idTurma}/{idEscola}")
	public List<FrequenciaDTO> listaFrequencia (@PathVariable(value = "idTurma") long idTurma,@PathVariable(value = "idEscola") long idEscola){
		
		return alunoRepository.listaFrequencia(idTurma,idEscola);
	}
	
	@GetMapping("aluno/{idAluno}/escola/{idEscola}")
	public AlunoControleAluno listaAlunoUnico(@PathVariable(value = "idAluno") long idAluno,@PathVariable(value = "idEscola") long idEscola) {

		AlunoControleAluno alunoControleAluno ;
		
		alunoControleAluno = alunoControleAlunoRepository.findByidControleAluno(idAluno, idEscola);
		
		return alunoControleAluno;
	}
	
	@GetMapping("/alunos/escola/{id}")
	public List<AlunoControleAluno> listaAlunosEscola(@PathVariable(value = "id") long id){
		
		List<AlunoControleAluno> listaAlunoControleAluno = new ArrayList<AlunoControleAluno>();
	
		List<Long> listAllId = alunoControleAlunoRepository.getAllId();	
		
		alunoControleAlunoRepository.findAllById(listAllId);
	
		for  (long idd: listAllId) {			
		
			listaAlunoControleAluno.add(alunoControleAlunoRepository.eee(idd));
		}
		
		return listaAlunoControleAluno;
	}
	
	@GetMapping("alunos/{nome}/escola/{idEscola}")
	public List<Aluno> listaNome(@PathVariable(value = "nome") String nome,@PathVariable(value = "idEscola") long idEscola) {
		return alunoRepository.findByNome(nome,idEscola);

	}

	@GetMapping("/testeAluno")
	public List<AlunoDTO> listaTeste() {
		return alunoRepository.todosAlunos(alunoRepository.count());
	}

	@PostMapping("/aluno")
	public void salvaAluno( String nome, int idade, MultipartFile foto ,int carteiraIdentidade, TipoGenero genero, long turma, long escola) throws IOException {
				
		Turma t = turmaRepository.findById(turma);
		turmaRepository.flush();
		Escola e = escolaRepository.findById(escola);
	
		Aluno aluno = new  Aluno(nome, idade, foto.getBytes(), carteiraIdentidade, genero,t,e);
		 alunoRepository.save(aluno);	
		 
		 ControleAluno controleAluno = new ControleAluno( TipoHorario.NOVO, aluno);
		
		AlunoControleAluno alunoControleAluno = new AlunoControleAluno(aluno, controleAluno, aluno.getEscola());
		
		alunoControleAlunoRepository.save(alunoControleAluno);
	}
	
	@PostMapping("/aluno2")
	public Aluno salvaAluno2( String nome, int idade, MultipartFile foto ,int carteiraIdentidade, TipoGenero genero, long turma, Escola escola) throws IOException {
		Turma t = turmaRepository.findById(turma);
		Aluno aluno = new  Aluno(nome, idade, foto.getBytes(), carteiraIdentidade, genero,t, escola);
		return alunoRepository.save(aluno);
	}
	
	
	@DeleteMapping("/aluno/{idAluno}/escola/{idEscola}")
	public String deletaAluno(@PathVariable(value = "idAluno") long idAluno,@PathVariable(value = "idEscola") long idEscola) {
		ArrayList<Long> listIdAluno = alunoResponsavelRepository.getIdRelacionamentoAluno(idAluno,idEscola);
		alunoResponsavelRepository.flush();		
		for(long elem : listIdAluno){			
			alunoResponsavelRepository.deleteById(elem);	
		}
		
		List<AlunoControleAluno> listAlunoControleAluno = alunoControleAlunoRepository.getAlunoControleAlunoByIdList(idAluno);
		for(AlunoControleAluno thisAlunoControleAluno : listAlunoControleAluno){		
			alunoControleAlunoRepository.delete(thisAlunoControleAluno);	
		}					
		alunoRepository.deleteById(idAluno);		
		return "deu certo";
	}
	
	@DeleteMapping("/2/aluno/{id}")
	public String deletaAlunoSemPai(@PathVariable(value = "id") long id) {
	alunoRepository.deleteById(id);
	return "deu certo";
	}
	
	@PutMapping("/aluno")
	public String salvaAlunos(int id_aluno,String nome, int idade, MultipartFile foto,int carteiraIdentidade, TipoGenero genero, int id_turma) throws IOException {
	
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
	   
	}

}
