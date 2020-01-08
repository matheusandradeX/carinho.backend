package com.ifsp.hto.carinho.backend.model;

import org.springframework.web.multipart.MultipartFile;

public class FormWrapper {

	
	
	private MultipartFile image;
    private String nome;
    private String sexo;
    public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	private int idade;
    private int carteiraIdentidade;
   
	public int getCarteiraIdentidade() {
		return carteiraIdentidade;
	}
	public void setCarteiraIdentidade(int carteiraIdentidade) {
		this.carteiraIdentidade = carteiraIdentidade;
	}
	public MultipartFile getImage() {
		return image;
	}
	public void setImage(MultipartFile image) {
		this.image = image;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	
	
	
	
	
	
	
}
