package com.ifsp.hto.carinho.backend.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Responsavel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String nome;
	private Date dataNascimento;
	private int CarteiraIdentidade;
	
	

	
	
	
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
	public int getCarteiraIdentidade() {
		return CarteiraIdentidade;
	}
	public void setCarteiraIdentidade(int carteiraIdentidade) {
		CarteiraIdentidade = carteiraIdentidade;
	}
	

}
