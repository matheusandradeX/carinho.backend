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
import javax.persistence.OneToOne;

import org.hibernate.envers.Audited;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class AlunoResponsavel implements Serializable {
	

	@OneToOne
	@JoinColumn(name = "fk_escola")
	private Escola escola;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@ManyToOne()
	@JoinColumn(name = "nome", referencedColumnName = "id")
	 @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
	private Aluno aluno;
	
	@ManyToOne()
	@JoinColumn(name = "nome_resp", referencedColumnName = "id")
	 @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
	private Responsavel responsavel;

	public AlunoResponsavel(Escola escola, Aluno aluno, Responsavel responsavel) {
		this.escola = escola;
		this.aluno = aluno;
		this.responsavel = responsavel;
	}

	public AlunoResponsavel() {
		
	}

	public Escola getEscola() {
		return escola;
	}

	public void setEscola(Escola escola) {
		this.escola = escola;
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
