package com.ifsp.hto.carinho.backend.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;


public class AlunoControleAluno {
	
	
	@JoinColumn(name = "fk_aluno")
	public List<Aluno> aluno;
	
	@JoinColumn(name = "fk_controleAluno")
	public ControleAluno controleAluno;


	
	
	
	
}
