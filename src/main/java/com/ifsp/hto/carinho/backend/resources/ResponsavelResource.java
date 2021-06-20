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
import com.ifsp.hto.carinho.backend.model.Responsavel;
import com.ifsp.hto.carinho.backend.model.TipoGenero;
import com.ifsp.hto.carinho.backend.model.TipoResponsavel;
import com.ifsp.hto.carinho.backend.repository.ResponsavelRepository;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
public class ResponsavelResource {

	@Autowired(required = true)
	ResponsavelRepository responsavelRepository;
	
	@GetMapping("responsavel/{id}")
	public Responsavel responsavel(@PathVariable(value = "id") int id) {
		return responsavelRepository.findById(id);
	}
	
	@GetMapping("responsaveis")
	public List<Responsavel> teste (){
		
		return responsavelRepository.findAll();
	}

	
	
		@PostMapping("/responsavel") 
	public Responsavel salvaResponsavel( String nomeResp, Integer carteiraIdentidade, int telefone, TipoResponsavel tipoResponsavel,MultipartFile foto) throws IOException {
		
			Random gerador = new Random();
			long id = gerador.nextInt();
		Responsavel responsavel = new Responsavel(id,nomeResp, carteiraIdentidade, tipoResponsavel, telefone,foto.getBytes());
		
	return responsavelRepository.save(responsavel);
	
	}
	/*

	
	@PostMapping("/responsavel") 
	public String salvaResponsavel(String nomeResp, Date dataNascimento,int numero) {
		System.out.printf("NUMEROOOO: ",numero);
		return "testeeeeeeeeeeeeeeeeeee";
	}
	*/


	
	
	
	
	
	
}
