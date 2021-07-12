package com.ifsp.hto.carinho.backend.model;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;


@Entity
public class Turma implements Serializable{


	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String numeroTurma;
	
	
	@ManyToOne(cascade=CascadeType.ALL, optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "professor_responsavel", referencedColumnName = "id")
	 @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
	private String professorResponsavel;

	public String getNumeroTurma() {
		return numeroTurma;
	}

	public void setNumeroTurma(String numeroTurma) {
		this.numeroTurma = numeroTurma;
	}

	public String getProfessorResponsavel() {
		return professorResponsavel;
	}

	public void setProfessorResponsavel(String professorResponsavel) {
		this.professorResponsavel = professorResponsavel;
	}

	public Turma(String numeroTurma, String professorResponsavel) {
		this.numeroTurma = numeroTurma;
		this.professorResponsavel = professorResponsavel;
	}
	
	
	
	public Turma() {
		
	}
	
	
	
}
