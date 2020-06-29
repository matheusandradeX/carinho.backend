package com.ifsp.hto.carinho.backend.model;

public enum TipoResponsavel {

	PAI("Pai"),
	MAE("Mae"),
	RESPONSAVEL("Re"),
	PARENTE1GRAU("1G"),
	BABA("Baba"),
	CONSELHOTUTELAR("Ct");
	
	private String tipo;
	
	private TipoResponsavel(String tipo) {
		this.tipo = tipo;
		// TODO Auto-generated constructor stub
	}

	public String getTipo() {
		return tipo;
	}
	
	

	
}
