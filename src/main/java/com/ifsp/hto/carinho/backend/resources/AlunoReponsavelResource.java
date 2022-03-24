package com.ifsp.hto.carinho.backend.resources;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ifsp.hto.carinho.backend.dto.ResponsavelDTO;
import com.ifsp.hto.carinho.backend.model.Aluno;
import com.ifsp.hto.carinho.backend.model.AlunoResponsavel;
import com.ifsp.hto.carinho.backend.model.Responsavel;
import com.ifsp.hto.carinho.backend.model.TipoGenero;
import com.ifsp.hto.carinho.backend.model.TipoResponsavel;
import com.ifsp.hto.carinho.backend.model.Turma;
import com.ifsp.hto.carinho.backend.repository.AlunoRepository;
import com.ifsp.hto.carinho.backend.repository.AlunoResponsavelRepository;
import com.ifsp.hto.carinho.backend.repository.ResponsavelRepository;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
public class AlunoReponsavelResource {

	@Autowired(required = true)
	AlunoResponsavelRepository alunoresponsavel;
	@Autowired(required = true)
	ResponsavelRepository responsavelRepository;
	@Autowired(required = true)
	AlunoRepository alunoRepository;
	
	 
	
	@GetMapping("/alunoResponsavel")
	public List<AlunoResponsavel> teste (){
		
		return alunoresponsavel.findAll();
	}
	@PostMapping("/alunoresponsavel") 
	public AlunoResponsavel salvar(int alunoId, int responsavelId) {
						
			Aluno aluno =  alunoRepository.findById(alunoId);
			Responsavel responsavel = responsavelRepository.findById(responsavelId);		
			AlunoResponsavel alunoResponsavel = new AlunoResponsavel(aluno.getEscola(),aluno, responsavel);
			return alunoresponsavel.save(alunoResponsavel);
		}
	

	@GetMapping("/testeAmazon")
	public String  testeAmazon(){
		
		return "Servidor está Online!";
	}
		
		
}
