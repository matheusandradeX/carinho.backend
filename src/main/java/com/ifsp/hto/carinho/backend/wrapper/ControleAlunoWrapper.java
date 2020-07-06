package com.ifsp.hto.carinho.backend.wrapper;



import com.ifsp.hto.carinho.backend.model.TipoHorario;

public class ControleAlunoWrapper {
	 
	
	private long id;

	private TipoHorario tipoHorario;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public TipoHorario getTipoHorario() {
		return tipoHorario;
	}

	public void setTipoHorario(TipoHorario tipoHorario) {
		this.tipoHorario = tipoHorario;
	}
	
	
}
