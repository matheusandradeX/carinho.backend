package com.ifsp.hto.carinho.backend.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
public class AlunoTurma implements Serializable {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	
	
	@ManyToOne(cascade=CascadeType.ALL, optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_aluno", referencedColumnName = "id")
	 @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
	private Aluno aluno;
	
	@ManyToOne(cascade=CascadeType.ALL, optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_turma", referencedColumnName = "id")
	 @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
	private Turma turma;
	
}
