package com.ifsp.hto.carinho.backend.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;
import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Audited
public class Aluno implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	private String nome;

	@Column(length = 255)
	private int idade;

	@Enumerated(value = EnumType.STRING)
	private TipoGenero genero;

	@JsonFormat(pattern = "dd/MM/yyy", shape = Shape.STRING)
	private Date dataNascimento;

	
	private long carteiraIdentidade;

	@NotAudited
	@ManyToOne
	@JoinColumn(name = "fk_escola")
	private Escola escola;
	
	
	@NotAudited
	@ManyToOne
	@JoinColumn(name = "fk_turma_id",insertable = true,updatable = true)
	private Turma turma;
	
	@Lob
	@Basic(fetch = FetchType.LAZY)
	private byte[] foto;
	
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

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public TipoGenero getGenero() {
		return genero;
	}

	public void setGenero(TipoGenero genero) {
		this.genero = genero;
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

	public Escola getEscola() {
		return escola;
	}

	public void setEscola(Escola escola) {
		this.escola = escola;
	}




	public Turma getTurma() {
		return turma;
	}



	public void setTurma(Turma turma) {
		this.turma = turma;
	}



	public byte[] getFoto() {
		return foto;
	}



	public void setFoto(byte[] foto) {
		this.foto = foto;
	}



	public Aluno() {

	}



	public Aluno(String nome, int idade, byte[] foto,int carteiraIdentidade,TipoGenero genero, Turma turma, Escola escola, List<ControleAluno> listaControleAluno) {
		this.nome = nome;
		this.idade = idade;
		this.genero = genero;
		this.carteiraIdentidade = carteiraIdentidade;
		this.foto = foto;
		this.turma = turma;
		this.escola = escola;
		
		
	}
	

	public Aluno(String nome, int idade, byte[] foto,int carteiraIdentidade,TipoGenero genero, Turma turma, Escola escola) {
		this.nome = nome;
		this.idade = idade;
		this.genero = genero;
		this.carteiraIdentidade = carteiraIdentidade;
		this.foto = foto;
		this.turma = turma;
		this.escola = escola;	
		
		
	}
	
	




	

}
