package com.ifsp.hto.carinho.backend.resources;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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
import com.ifsp.hto.carinho.backend.repository.AlunoResponsavelRepository;
import com.ifsp.hto.carinho.backend.repository.ResponsavelRepository;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
public class ResponsavelResource {

	@Autowired(required = true)
	ResponsavelRepository responsavelRepository;
	@Autowired(required = true)
	AlunoResponsavelRepository alunoResponsavelRepository;
	
	@GetMapping("responsavel/{id}")
	public List<ResponsavelDTO> responsavel(@PathVariable(value = "id") int id) {
			
		return responsavelRepository.responsavel(id);
	}
	
	@GetMapping("responsaveis")
	public List<Responsavel> teste (){
		
		return responsavelRepository.findAll();
	}
		@PostMapping("/responsavel") 
	public Responsavel salvaResponsavel( String nomeResp, Integer carteiraIdentidade, int telefone, TipoResponsavel tipoResponsavel,MultipartFile foto) throws IOException {
			
		Responsavel responsavel = new Responsavel(nomeResp, carteiraIdentidade, tipoResponsavel, telefone,foto.getBytes());
		
	return responsavelRepository.save(responsavel);
	
	}
		@DeleteMapping("/responsavel/{idResponsavel}/idEscola/{idEscola}")
		public String deletar(@PathVariable(value = "idResponsavel") long idResponsavel,@PathVariable(value = "idEscola") long idEscola) {
			
			ArrayList<Long> listIdResponsavel = alunoResponsavelRepository.getIdRelacionamentoResponsavel(idResponsavel,idEscola);
			alunoResponsavelRepository.flush();		
			for(long elem : listIdResponsavel){			
				alunoResponsavelRepository.deleteById(elem);	
			}
			
			responsavelRepository.deleteById(idResponsavel);
			
			return "deu certo";
		}
		
	
		
		
		
		

}
