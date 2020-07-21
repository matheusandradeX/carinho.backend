package com.ifsp.hto.carinho.backend.dto;

import java.util.Date;

import com.ifsp.hto.carinho.backend.model.TipoGenero;
import com.ifsp.hto.carinho.backend.model.TipoHorario;

public interface AlunoDTO {

	public int getId();

	public String getNome();

	public int getIdade();

	public TipoGenero getGenero();

	public Date getData_Nascimento();

	public int getCarteira_Identidade();

	public byte[] getFoto();

	public TipoHorario getTipo_Horario();

	public String gethorario();

}
