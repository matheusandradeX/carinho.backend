package com.ifsp.hto.carinho.backend.resources;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ifsp.hto.carinho.backend.model.Aluno;
import com.ifsp.hto.carinho.backend.repository.AlunoRepository;
import com.ifsp.hto.carinho.backend.util.Disco;

@RestController
@RequestMapping("/fotos")
public class FotoResources {



	Disco disco = new Disco();


	byte[] teste;

	@PostMapping
	public void upload(@RequestParam MultipartFile foto) {
		disco.salvarFoto(foto);
		try {

			teste= foto.getBytes();

		} catch (Exception e) {

		}


	}




}
