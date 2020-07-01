package com.ifsp.hto.carinho.backend.model;

public enum TipoGenero {

	MASCULINO("Masculino"), FEMININO("Feminino");

	private String tipo;

	private TipoGenero(String tipo) {
		this.tipo = tipo;
		
	}

	public String getTipo() {
		return tipo;
	}

}
