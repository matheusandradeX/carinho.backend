package com.ifsp.hto.carinho.backend.model;

import java.awt.print.Book;
import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ifsp.hto.carinho.backend.repository.AlunoRepository;
import com.ifsp.hto.carinho.backend.repository.ResponsavelRepository;

@Entity
public class AlunoResponsavel implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@ManyToOne(cascade=CascadeType.ALL, optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "nome", referencedColumnName = "id")
	 @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
	private Aluno aluno;
	
	//@Column(name="nome",insertable = false, updatable = false)
	//int alunoId;
	
	@ManyToOne(cascade=CascadeType.ALL, optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "nome_resp", referencedColumnName = "id")
	 @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
	private Responsavel responsavel;
	
	//@Column(name ="nome_resp",insertable = false, updatable = false)
	//int responsavelId;

	//public AlunoResponsavel(int alunoId, int responsavelId) {
		
	//	this.alunoId = alunoId;
	//	this.responsavelId = responsavelId;
	//}

	public long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Responsavel getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Responsavel responsavel) {
		this.responsavel = responsavel;
	}

	public AlunoResponsavel(Aluno a, Responsavel r) {
		this.aluno = a;
		this.responsavel = r;
	}

	public AlunoResponsavel() {
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
