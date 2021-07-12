package com.ifsp.hto.carinho.backend.model;

public enum TipoUsuario {

	ADMINISTRADOR("administrador"), PROFESSOR("professor"), MONITOR("monitor");

	private String tipo;

	private TipoUsuario(String tipo) {
		this.tipo = tipo;
		// TODO Auto-generated constructor stub
	}

	public String getTipo() {
		return tipo;
	}

}
