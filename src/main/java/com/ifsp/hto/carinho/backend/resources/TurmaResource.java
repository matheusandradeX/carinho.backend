package com.ifsp.hto.carinho.backend.resources;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ifsp.hto.carinho.backend.dto.TurmaDTO;
import com.ifsp.hto.carinho.backend.model.Escola;
import com.ifsp.hto.carinho.backend.model.Login;
import com.ifsp.hto.carinho.backend.model.Responsavel;
import com.ifsp.hto.carinho.backend.model.TipoUsuario;
import com.ifsp.hto.carinho.backend.model.Turma;
import com.ifsp.hto.carinho.backend.repository.AlunoRepository;
import com.ifsp.hto.carinho.backend.repository.EscolaRepository;
import com.ifsp.hto.carinho.backend.repository.TurmaRepository;
import com.ifsp.hto.carinho.backend.util.MD5;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
public class TurmaResource {

	@Autowired(required = true)
	TurmaRepository turmaRepository;
	
	@Autowired(required = true)
	AlunoRepository alunoRepository;
	
	@Autowired(required = true)
	EscolaRepository escolaRepository;
	
	@GetMapping("/turmas/escola/{idEscola}")
	public List<Turma> lista (@PathVariable(value = "idEscola") long idEscola){
		
		return turmaRepository.listaTurmas(idEscola);
	}
	
	@PostMapping("/cadastrarTurma")
	public Turma  cadastro(String numeroTurma, String professorResponsavel, long idEscola){
		
		Escola escola = escolaRepository.findById(idEscola);
		Turma turma = new Turma(numeroTurma,professorResponsavel);
		return turmaRepository.save(turma);
				
	}
	
	@GetMapping("turma/{idTurma}/{idEscola}")
	public List<TurmaDTO> listaAlunos(@PathVariable(value = "idTurma") long idTurma,@PathVariable(value = "idEscola") long idEscola) {
		
		return alunoRepository.listaTurmas(idTurma,idEscola);
	}

}
