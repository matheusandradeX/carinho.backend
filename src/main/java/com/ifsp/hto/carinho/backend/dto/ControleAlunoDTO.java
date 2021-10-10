package com.ifsp.hto.carinho.backend.dto;


import java.text.SimpleDateFormat;
import java.util.Date;

import com.ifsp.hto.carinho.backend.model.TipoHorario;

public interface ControleAlunoDTO {
	
	public int getId();
	
	public String getfk_aluno();
	
	public Date getHorario();

	public TipoHorario getTipo_Horario();
	
	


	

}
