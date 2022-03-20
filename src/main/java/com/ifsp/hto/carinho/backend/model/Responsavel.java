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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

import org.hibernate.envers.Audited;

@Entity
@Audited
public class Responsavel implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@OneToOne
	@JoinColumn(name = "fk_escola")
	private Escola escola;
	private String nomeResp;
	private Date dataNascimento;
	private long carteiraIdentidade;
	@Enumerated(value = EnumType.STRING)
	private TipoResponsavel tipoResponsavel;
	private long telefone;
	
	public TipoResponsavel getTipoResponsavel() {
		return tipoResponsavel;
	}
	public void setTipoResponsavel(TipoResponsavel tipoResponsavel) {
		this.tipoResponsavel = tipoResponsavel;
	}
	public long getTelefone() {
		return telefone;
	}
	public void setTelefone(long telefone) {
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
	public Responsavel(String nomeResp, Date dataNascimento, long carteiraIdentidade, long telefone) {
		
		this.nomeResp = nomeResp;
		this.dataNascimento = dataNascimento;
		this.carteiraIdentidade = carteiraIdentidade;
		this.telefone = telefone; 
	}
	
	
	
	public Responsavel(String nomeResp, long carteiraIdentidade, TipoResponsavel tipoResponsavel, long telefone,byte[] foto, Escola escola) {
		this.nomeResp = nomeResp;
		this.carteiraIdentidade = carteiraIdentidade;
		this.tipoResponsavel = tipoResponsavel;
		this.telefone = telefone;
		this.foto = foto;
		this.escola = escola;
	}
	public Responsavel(String nomeResp, Date dataNascimento, long carteiraIdentidade, TipoResponsavel tipoResponsavel,long telefone) {
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

	public long getCarteiraIdentidade() {
		return carteiraIdentidade;
	}

	public void setCarteiraIdentidade(long carteiraIdentidade) {
		this.carteiraIdentidade = carteiraIdentidade;
	}

	
	
	

}
