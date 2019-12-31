package com.ifsp.hto.carinho.backend.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;





@Entity
public class Aluno implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataDascimento() {
		return dataNascimento;
	}

	public void setDataDascimento(Date dataDascimento) {
		this.dataNascimento = dataDascimento;
	}

	public String getTurma() {
		return turma;
	}

	public void setTurma(String turma) {
		this.turma = turma;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public int getCarteiraIdentidade() {
		return CarteiraIdentidade;
	}

	public void setCarteiraIdentidade(int carteiraIdentidade) {
		CarteiraIdentidade = carteiraIdentidade;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String nome;
	
	private Date dataNascimento;
	
	private String turma ;
	
	private String periodo;
	
	private int CarteiraIdentidade;
	
	
	


}
