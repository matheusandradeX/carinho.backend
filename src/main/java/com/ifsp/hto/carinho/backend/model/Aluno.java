package com.ifsp.hto.carinho.backend.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.web.multipart.MultipartFile;





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






	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
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



	public Byte[] getFoto() {
		return foto;
	}





	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String nome;
	
	@Column(length=255)
	private int idade;
		
	private String sexo;
	
	private Date dataNascimento;
	
	private int carteiraIdentidade;
	
	@Column(columnDefinition = "LONGBLOB")
	private Byte[] foto;
	
	
	


}
