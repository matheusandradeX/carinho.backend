package com.ifsp.hto.carinho.backend.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.ifsp.hto.carinho.backend.model.TipoHorario;

public interface FrequenciaDTO {

	public String getNome();
	
	@JsonFormat(pattern = "dd/MM/yyy", shape = Shape.STRING)
	public Date getHorario();

	
	
	
	public TipoHorario getTipo_Horario();
	
	
	
	
}
