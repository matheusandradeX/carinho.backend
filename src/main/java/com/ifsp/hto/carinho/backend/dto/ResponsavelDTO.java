package com.ifsp.hto.carinho.backend.dto;

import com.ifsp.hto.carinho.backend.model.TipoResponsavel;

public interface ResponsavelDTO {

	/**
	 * Interface para objeto dto (Data Transfer Object) de informação do responsavel
	 */

	public int getId();

	public String getCarteira_identidade();

	public String getNome_resp();

	public TipoResponsavel getTipo_responsavel();

	public byte[] getFoto();

	public int getTelefone1();

	public int getTelefone2();

}
