package com.ifsp.hto.carinho.backend.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ifsp.hto.carinho.backend.dto.FrequenciaDTO;
import com.ifsp.hto.carinho.backend.model.Escola;
import com.ifsp.hto.carinho.backend.repository.EscolaRepository;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
public class EscolaResource {

	@Autowired(required = true)
	EscolaRepository escolaRepository;
	
	@GetMapping("/escolas")
	public List<Escola> listaEscolas (){
		
		return escolaRepository.findAll();
		
	}
	
	@PostMapping("/escola")
	public Escola salvarEscola(String nome) {
		Escola escola = new Escola(nome);
		return escolaRepository.save(escola);
	}
	
}
