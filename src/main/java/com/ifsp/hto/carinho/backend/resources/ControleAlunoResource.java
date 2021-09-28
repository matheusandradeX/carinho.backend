package com.ifsp.hto.carinho.backend.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ifsp.hto.carinho.backend.dto.ControleAlunoDTO;
import com.ifsp.hto.carinho.backend.model.Aluno;
import com.ifsp.hto.carinho.backend.model.ControleAluno;
import com.ifsp.hto.carinho.backend.model.TipoHorario;
import com.ifsp.hto.carinho.backend.repository.AlunoRepository;
import com.ifsp.hto.carinho.backend.repository.ControleAlunoRepository;
import com.ifsp.hto.carinho.backend.repository.EscolaRepository;
import com.ifsp.hto.carinho.backend.util.Utility;
import com.ifsp.hto.carinho.backend.wrapper.ControleAlunoWrapper;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
public class ControleAlunoResource {
	@Autowired(required = true)
	EscolaRepository escolaRepository;
	
	
	@Autowired(required = true)
	AlunoRepository alunoRepository;

	@Autowired(required = true)
	ControleAlunoRepository controleAlunoRepository;


	@PostMapping("/controle")
	public ControleAluno lista2(TipoHorario tipoHorario,long idAluno) {	
		
		
		System.out.println("---------Controle Aluno--------");
		System.out.println("Tipo horario: "+tipoHorario);
		System.out.println("id aluno    : "+idAluno);
		
		Aluno al = alunoRepository.findById(idAluno);
		
		ControleAluno controleAluno = new ControleAluno(
				Utility.getDate("Brazil/East"),tipoHorario,al.getEscola()
				);
		
		
		System.out.println("Fk_escola:");
	//	System.out.println(controleAluno.getAluno().getEscola().getId());
		
		
		
		return controleAlunoRepository.save(controleAluno);
		
		}
	
	

	@GetMapping("/controle")
	public ResponseEntity<List<ControleAluno>> listaHorario() {

		return new ResponseEntity<>(controleAlunoRepository.findAll(), HttpStatus.OK);

	}
	
	@GetMapping("/ultimoRegistro/aluno/{idAluno}/escola/{idEscola}")
	public ControleAlunoDTO ultimoRegistro(@PathVariable(value = "idAluno")long idAluno,@PathVariable(value = "idEscola")long idEscola ) {
		System.out.println("-------------------------");
		System.out.println("id aluno : "+idAluno);
		System.out.println("id escola: "+idEscola);
		
		long cont = controleAlunoRepository.cont(idAluno,idEscola);
		
		System.out.println("O VALOR DE CONT É: "+cont);
		return controleAlunoRepository.resultado(cont,idAluno,idEscola);
		
	}
	
	@GetMapping("/ultimoResgistro/{idEscola}")
	public List<ControleAluno> ultimoRegistros(@PathVariable(value = "idEscola")long idEscola) {
		
		System.out.println(controleAlunoRepository.myFindAll(idEscola));
		
		 List<ControleAluno> listacontroleAluno = controleAlunoRepository.myFindAll(idEscola);
	 
		 List<ControleAluno> newlistacontroleAluno = new ArrayList<ControleAluno>();
		 
	     for(ControleAluno thisControleAluno : listacontroleAluno){
		         
	         newlistacontroleAluno.add(thisControleAluno);
	          
	     }
		
		return newlistacontroleAluno;
	}
	
	
	
	
	
	

}
