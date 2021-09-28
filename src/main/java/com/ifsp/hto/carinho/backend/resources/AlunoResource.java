package com.ifsp.hto.carinho.backend.resources;

import java.io.IOException;
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
import com.ifsp.hto.carinho.backend.model.AlunoResponsavel;
import com.ifsp.hto.carinho.backend.model.ControleAluno;
import com.ifsp.hto.carinho.backend.model.Escola;
import com.ifsp.hto.carinho.backend.model.TipoGenero;
import com.ifsp.hto.carinho.backend.model.Turma;
import com.ifsp.hto.carinho.backend.repository.AlunoRepository;
import com.ifsp.hto.carinho.backend.repository.AlunoResponsavelRepository;
import com.ifsp.hto.carinho.backend.repository.ControleAlunoRepository;
import com.ifsp.hto.carinho.backend.repository.EscolaRepository;
import com.ifsp.hto.carinho.backend.repository.TurmaRepository;
import com.ifsp.hto.carinho.backend.wrapper.AlunoControleAlunoWrapper;
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
	AlunoResponsavelRepository alunoResponsavelRepository;
	
	@Autowired(required = true)
	EscolaRepository escolaRepository;
	
	@GetMapping("turma/{id}")
	public List<TurmaDTO> listaAlunos (@PathVariable(value = "id") long id){
		
		return alunoRepository.listaTurmas(id);
	}
	
	@GetMapping("frequencia/{id}")
	public List<FrequenciaDTO> listaFrequencia (@PathVariable(value = "id") long id){
		
		return alunoRepository.listaFrequencia(id);
	}
	
	  
	@GetMapping("/alunos/escola/{id}")
	public List<AlunoControleAlunoWrapper> listaAlunosEscola(@PathVariable(value = "id") long id){
		
		List<AlunoControleAlunoWrapper> listaAlunoControleAlunoWrapper = new ArrayList<AlunoControleAlunoWrapper>();
	
		
		List<Aluno> la = alunoRepository.findByEscola(id);	
		
		
		
		for (Aluno newAluno : la) {
			AlunoControleAlunoWrapper newWrapper;
			if (!newAluno.getL_ControleAluno().isEmpty()) {
				System.out.println("ENTROU AQUI");
				int tamanhoLista = (newAluno.getL_ControleAluno().size() - 1);
				 newWrapper = new AlunoControleAlunoWrapper(newAluno.getId(),newAluno.getNome(),newAluno.getIdade(),newAluno.getGenero(),newAluno.getDataNascimento(),newAluno.getCarteiraIdentidade(),newAluno.getEscola(),newAluno.getL_ControleAluno().get(tamanhoLista));
      		}else {		
				newWrapper = new AlunoControleAlunoWrapper(newAluno.getId(),newAluno.getNome(),newAluno.getIdade(),newAluno.getGenero(),newAluno.getDataNascimento(),newAluno.getCarteiraIdentidade(),newAluno.getEscola(),null);
			}
			
			listaAlunoControleAlunoWrapper.add(newWrapper);		
			
			
			
		}
		
		
		return listaAlunoControleAlunoWrapper; 

	}
	@GetMapping("/alunos2/escola/{id}")
	public ArrayList<AlunoControleAlunoWrapper> listaAlunosEscola2(@PathVariable(value = "id") long idEscola){
		
		ArrayList<AlunoControleAlunoWrapper> listACW = new ArrayList();
		
		for (Aluno newAluno : alunoRepository.findAlunoByEscola(idEscola)) {		
			
			long cont = controleAlunoRepository.cont(newAluno.getId(),idEscola);		 
			
			System.out.println(controleAlunoRepository.resultado2(cont,newAluno.getId(),idEscola));
			
		    
	

			
		//	AlunoControleAlunoWrapper alunoControleAlunoWrapper = new AlunoControleAlunoWrapper(newAluno,ca);
	
        }
		
	return listACW;

	}
	
	
	
	@GetMapping("aluno/{id}")
	public Aluno listaAlunoUnico(@PathVariable(value = "id") long id) {
		return alunoRepository.findById(id);
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
	public Aluno salvaAluno( String nome, int idade, MultipartFile foto ,int carteiraIdentidade, TipoGenero genero, long turma, long escola) throws IOException {
		
		Turma t = turmaRepository.findById(turma);	
		Escola e = escolaRepository.findById(escola);
		Aluno aluno = new  Aluno(nome, idade, foto.getBytes(), carteiraIdentidade, genero,t,e);
		
		return alunoRepository.save(aluno);	
	}
	
	@PostMapping("/aluno2")
	public Aluno salvaAluno2( String nome, int idade, MultipartFile foto ,int carteiraIdentidade, TipoGenero genero, long turma, Escola escola) throws IOException {
		Turma t = turmaRepository.findById(turma);
		Aluno aluno = new  Aluno(nome, idade, foto.getBytes(), carteiraIdentidade, genero,t, escola);
		return alunoRepository.save(aluno);
	}
	
	
	@DeleteMapping("/aluno/{id}")
	public String deletaAluno(@PathVariable(value = "id") long id) {
		System.out.println("ID recebido          : "+id);
		ArrayList<Long> listIdAluno = alunoResponsavelRepository.getIdRelacionamentoAluno(id);
		alunoResponsavelRepository.flush();		
		for(long elem : listIdAluno){			
			alunoResponsavelRepository.deleteById(elem);
			System.out.println("ID aluno_responsavel: "+ elem +" deletado ");				
		}
		
		alunoRepository.deleteById(id);	
	return "deu certo";
	}
	
	@DeleteMapping("/2/aluno/{id}")
	public String deletaAlunoSemPai(@PathVariable(value = "id") long id) {
	alunoRepository.deleteById(id);
	return "deu certo";
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
		
		//return null
		
	}
	
	
}
