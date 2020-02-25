package com.ifsp.hto.carinho.backend.resources;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ifsp.hto.carinho.backend.model.Login;
import com.ifsp.hto.carinho.backend.repository.LoginRepository;
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class LoginResource {
	
	@Autowired(required = true)
	LoginRepository loginRepository;
	
	
	
	@GetMapping("login/{id}")
	public Login listaLogin(@PathVariable(value ="id")long id) {
		return loginRepository.findById(id);
	}

	@PostMapping("login")
	public Login autenticar(@RequestBody Login login) {
		return loginRepository.save(login);
	}
	
}
