package com.ifsp.hto.carinho.backend.wrapper;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.ifsp.hto.carinho.backend.model.Aluno;
import com.ifsp.hto.carinho.backend.model.ControleAluno;
import com.ifsp.hto.carinho.backend.model.Escola;
import com.ifsp.hto.carinho.backend.model.TipoGenero;

public class AlunoControleAlunoWrapper {
	
	private long id;

	private String nome;

	
	private int idade;


	private TipoGenero genero;

	@JsonFormat(pattern = "dd/MM/yyy", shape = Shape.STRING)
	private Date dataNascimento;

	private int carteiraIdentidade;


	private Escola escola;	
	
	
	private ControleAluno l_ControleAluno;


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


	public int getCarteiraIdentidade() {
		return carteiraIdentidade;
	}


	public void setCarteiraIdentidade(int carteiraIdentidade) {
		this.carteiraIdentidade = carteiraIdentidade;
	}


	public Escola getEscola() {
		return escola;
	}


	public void setEscola(Escola escola) {
		this.escola = escola;
	}


	public ControleAluno getL_ControleAluno() {
		return l_ControleAluno;
	}


	public void setL_ControleAluno(ControleAluno l_ControleAluno) {
		this.l_ControleAluno = l_ControleAluno;
	}


	public AlunoControleAlunoWrapper(long id, String nome, int idade, TipoGenero genero, Date dataNascimento,
			int carteiraIdentidade, Escola escola, ControleAluno l_ControleAluno) {
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.genero = genero;
		this.dataNascimento = dataNascimento;
		this.carteiraIdentidade = carteiraIdentidade;
		this.escola = escola;
		this.l_ControleAluno = l_ControleAluno;
	}


	public AlunoControleAlunoWrapper() {
	}
	
	
	
}
