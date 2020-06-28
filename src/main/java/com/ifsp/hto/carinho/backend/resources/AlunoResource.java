package com.ifsp.hto.carinho.backend.resources;

import java.util.List;

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

import com.ifsp.hto.carinho.backend.dto.ResponsavelDTO;
import com.ifsp.hto.carinho.backend.dto.TesteDTO;
import com.ifsp.hto.carinho.backend.model.Aluno;
import com.ifsp.hto.carinho.backend.model.FormWrapper;
import com.ifsp.hto.carinho.backend.repository.AlunoRepository;


@RestController
@RequestMapping(value ="/api")
@CrossOrigin(origins = "*")
public class AlunoResource {

	
	

	@Autowired(required = true)
	AlunoRepository alunoRepository;

@GetMapping("tudo")
	public List<Aluno> listaTudo(){
		return alunoRepository.findByResponsavel();
}
	

//@GetMapping("/dept/employees/left")
//public ResponseEntity<List<DeptEmpLDto>> getDeptEmployeesLeftJoin() {
//	return new ResponseEntity<List<DeptEmpDto>>(joinQueryService.getDeptEmployeesLeftJoin(), HttpStatus.OK);
//}


@GetMapping("left")
public List<TesteDTO> left(){
	return alunoRepository.teste();
}


	
	@GetMapping("alunos")
	public Page<Aluno> listaAlunos(Pageable pageable){
		return alunoRepository.findAll(pageable);
	}

	
	@GetMapping("left/{id}")
	public List<ResponsavelDTO> responsavel(@PathVariable(value ="id") int id){
		return alunoRepository.responsavel(id);
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
