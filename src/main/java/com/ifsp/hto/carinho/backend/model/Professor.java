package com.ifsp.hto.carinho.backend.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.envers.Audited;

@Entity
public class Professor  implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	@OneToOne
	@JoinColumn(name = "fk_escola")
	private Escola escola;
	
	String nome; 
	
	String turma;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTurma() {
		return turma;
	}

	public void setTurma(String turma) {
		this.turma = turma;
	}

	public Professor(String nome, String turma) {
		this.nome = nome;
		this.turma = turma;
	}
	
	
	public Professor() {
	
	}
	
	
}
