package com.ifsp.hto.carinho.backend.model;

import java.io.Serializable;
import java.time.ZonedDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class ControleAluno implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private ZonedDateTime horario;

	@Enumerated(value = EnumType.STRING)
	private TipoHorario tipoHorario;

	public ControleAluno() {

	}

	public ControleAluno(ZonedDateTime horario, TipoHorario tipoHorario, Aluno aluno) {
		super();
		this.horario = horario;
		this.tipoHorario = tipoHorario;
		this.aluno = aluno;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	//@OneToOne
	//@JoinColumn(name = "fk_aluno")
	private Aluno aluno;

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

}
