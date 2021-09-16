package com.ifsp.hto.carinho.backend.wrapper;



import com.ifsp.hto.carinho.backend.model.Escola;
import com.ifsp.hto.carinho.backend.model.TipoHorario;

public class ControleAlunoWrapper {
	 
	
	private long id;

	private TipoHorario tipoHorario;
	
	private Escola escola;
	
	
	


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

	public TipoHorario getTipoHorario() {
		return tipoHorario;
	}

	public void setTipoHorario(TipoHorario tipoHorario) {
		this.tipoHorario = tipoHorario;
	}
	

	
	
}
