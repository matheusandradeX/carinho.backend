package com.ifsp.hto.carinho.backend.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Responsavel implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String nomeResp;
	private Date dataNascimento;
	private Integer carteiraIdentidade;
	@Enumerated(value = EnumType.STRING)
	private TipoResponsavel tipoResponsavel;
	private int telefone;
	
	
	
	public TipoResponsavel getTipoResponsavel() {
		return tipoResponsavel;
	}
	public void setTipoResponsavel(TipoResponsavel tipoResponsavel) {
		this.tipoResponsavel = tipoResponsavel;
	}
	public int getTelefone() {
		return telefone;
	}
	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}

	@Lob
	@Basic(fetch = FetchType.LAZY)
	private byte[] foto;
	
	
	public byte[] getFoto() {
		return foto;
	}
	public void setFoto(byte[] foto) {
		this.foto = foto;
	}
	public Responsavel(String nomeResp, Date dataNascimento, int carteiraIdentidade, int telefone) {
		
		this.nomeResp = nomeResp;
		this.dataNascimento = dataNascimento;
		this.carteiraIdentidade = carteiraIdentidade;
		this.telefone = telefone; 
	}
	
	
	
	public Responsavel(String nomeResp, Integer carteiraIdentidade, TipoResponsavel tipoResponsavel, int telefone,
			byte[] foto) {
		this.nomeResp = nomeResp;
		this.carteiraIdentidade = carteiraIdentidade;
		this.tipoResponsavel = tipoResponsavel;
		this.telefone = telefone;
		this.foto = foto;
	
	}
	public Responsavel(String nomeResp, Date dataNascimento, int carteiraIdentidade, TipoResponsavel tipoResponsavel,
			int telefone) {
		this.nomeResp = nomeResp;
		this.dataNascimento = dataNascimento;
		this.carteiraIdentidade = carteiraIdentidade;
		this.tipoResponsavel = tipoResponsavel;
		this.telefone = telefone;
	
	}
	public Responsavel() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNomeResp() {
		return nomeResp;
	}

	public void setNomeResp(String nomeResp) {
		this.nomeResp = nomeResp;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public int getCarteiraIdentidade() {
		return carteiraIdentidade;
	}

	public void setCarteiraIdentidade(int carteiraIdentidade) {
		this.carteiraIdentidade = carteiraIdentidade;
	}

	
	
	

}
