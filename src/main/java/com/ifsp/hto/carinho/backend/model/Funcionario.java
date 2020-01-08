package com.ifsp.hto.carinho.backend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String nome;

	private String cargo;

	private String carteiraIdentidade;



	@ManyToOne
	@JoinColumn(name = "fk_login_id")
	private Login login;

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

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getCarteiraIdentidade() {
		return carteiraIdentidade;
	}

	public void setCarteiraIdentidade(String carteiraIdentidade) {
		this.carteiraIdentidade = carteiraIdentidade;
	}



}
