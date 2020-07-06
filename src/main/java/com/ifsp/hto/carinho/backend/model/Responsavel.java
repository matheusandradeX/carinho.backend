package com.ifsp.hto.carinho.backend.model;

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
public class Responsavel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String nomeResp;
	private Date dataNascimento;
	private int CarteiraIdentidade;

	private int telefone2;
	private int telefone1;

	public int getTelefone2() {
		return telefone2;
	}

	public void setTelefone2(int telefone2) {
		this.telefone2 = telefone2;
	}

	public int getTelefone1() {
		return telefone1;
	}

	public void setTelefone1(int telefone1) {
		this.telefone1 = telefone1;
	}

	@Enumerated(value = EnumType.STRING)
	private TipoResponsavel TipoResponsavel;

	@Lob
	@Basic(fetch = FetchType.LAZY)
	private byte[] foto;

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public long getId() {
		return id;
	}

	public TipoResponsavel getTipoResponsavel() {
		return TipoResponsavel;
	}

	public void setTipoResponsavel(TipoResponsavel tipoResponsavel) {
		TipoResponsavel = tipoResponsavel;
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
