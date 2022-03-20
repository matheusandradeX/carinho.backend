package com.ifsp.hto.carinho.backend.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;
import org.springframework.data.annotation.Reference;


	
@Entity
@Audited
public class AlunoControleAluno implements Serializable {

		
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	
	@OneToOne
	private Aluno aluno;
	
	@NotAudited
	@OneToOne(cascade = {CascadeType.ALL})
	private ControleAluno controleAluno;

	@NotAudited
	@OneToOne
	@JoinColumn(name = "fk_escola")
	private Escola escola ;

	
	
	
	
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public Aluno getAluno() {
		return aluno;
	}


	public Escola getEscola() {
		return escola;
	}


	public void setEscola(Escola escola) {
		this.escola = escola;
	}


	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}


	public ControleAluno getControleAluno() {
		return controleAluno;
	}


	public void setControleAluno(ControleAluno controleAluno) {
		this.controleAluno = controleAluno;
	}


	public AlunoControleAluno(Aluno aluno, ControleAluno controleAluno, Escola escola) {
		this.aluno = aluno;
		this.controleAluno = controleAluno;
		this.escola = escola;
	}
	
	public AlunoControleAluno() {

	}
	
	
	
	

}