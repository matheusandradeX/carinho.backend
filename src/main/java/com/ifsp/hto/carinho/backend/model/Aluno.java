package com.ifsp.hto.carinho.backend.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Type;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

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

	public TipoGenero getGenero() {
		return genero;
	}

	public void setGenero(TipoGenero genero) {
		this.genero = genero;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
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

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String nome;

	@Column(length = 255)
	private int idade;

	@Enumerated(value = EnumType.STRING)
	private TipoGenero genero;

	@JsonFormat(pattern = "dd/MM/yyy", shape = Shape.STRING)
	private Date dataNascimento;

	private int carteiraIdentidade;

	@Lob
	@Basic(fetch = FetchType.LAZY)
	private byte[] foto;

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public Aluno() {

	}

	public Aluno(String nome, int idade, TipoGenero genero, int carteiraIdentidade, byte[] foto) {

		this.nome = nome;
		this.idade = idade;
		this.genero = genero;
		this.carteiraIdentidade = carteiraIdentidade;
		this.foto = foto;

	}

	public Aluno(String nome, int idade, TipoGenero genero, int carteiraIdentidade, byte[] foto, Date dataNascimento) {
		this.nome = nome;
		this.idade = idade;
		this.genero = genero;
		this.carteiraIdentidade = carteiraIdentidade;
		this.foto = foto;
		this.dataNascimento = dataNascimento;

	}
	
	
	public Aluno(String nome, int idade, Date dataNascimento) {
		this.nome = nome;
		this.idade = idade;
		this.dataNascimento = dataNascimento;

	}
	
	
	

}
