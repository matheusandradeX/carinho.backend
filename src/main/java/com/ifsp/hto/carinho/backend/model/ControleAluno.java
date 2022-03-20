package com.ifsp.hto.carinho.backend.model;

import java.io.Serializable;
import java.time.ZonedDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.envers.Audited;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ifsp.hto.carinho.backend.util.Utility;

@Entity
@Audited
public class ControleAluno implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private ZonedDateTime horario;

	@Enumerated(value = EnumType.STRING)
	private TipoHorario tipoHorario;
	
	@OneToOne
	@JoinColumn(name = "fk_escola")
	private Escola escola;

	@JsonIgnore
	@OneToOne
	@JoinColumn(name = "fk_aluno")
	private Aluno aluno;
	
	public Escola getEscola() {
		return escola;
	}

	public void setEscola(Escola escola) {
		this.escola = escola;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public ZonedDateTime getHorario() {
		return horario;
	}

	public void setHorario(ZonedDateTime horario) {
		this.horario = horario;
	}

	public TipoHorario getTipoHorario() {
		return tipoHorario;
	}

	public void setTipoHorario(TipoHorario tipoHorario) {
		this.tipoHorario = tipoHorario;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	
		
	public ControleAluno() {

	}

	public ControleAluno( TipoHorario tipoHorario, Aluno aluno) {

		this.horario = Utility.getDate("Brazil/East");
		this.tipoHorario = tipoHorario;
		this.escola = aluno.getEscola();
		this.aluno = aluno;
	}
	

	


	
}
