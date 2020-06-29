package com.ifsp.hto.carinho.backend.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


@Entity
public class Responsavel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String nomeResp;
	private Date dataNascimento;
	private int CarteiraIdentidade;
	
	@Enumerated(value = EnumType.STRING)
	private TipoResponsavel TipoResponsavel;

	
	
	//@ManyToOne
	//@JoinColumn(name="fk_aluno_id")
	//@Fetch(FetchMode.JOIN)
	//private Aluno aluno;

	//@Query(value = "SELECT * from aluno INNER JOIN responsavel on aluno.id = responsavel.fk_aluno_id", nativeQuery = true)
	
	//@JoinColumn(name="fk_aluno_id")



	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}


	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public String getNomeResp() {
		return nomeResp;
	}
	public void setNomeResp(String nomeResp) {
		this.nomeResp = nomeResp;
	}


}
