package br.com.season.laboratorio10;

import java.io.Serializable;

public class Imovel implements Serializable {

	private String website;
	private String telefone;
	private String email;
	private String titulo;
	
	@Override
	public String toString() {
		return titulo;
	}

	public String getTitulo() {
		return titulo;
	}

	public Imovel setTitulo(String titulo) {
		this.titulo = titulo;
		return this;
	}

	public String getWebsite() {
		return website;
	}

	public Imovel setWebsite(String website) {
		this.website = website;
		return this;
	}

	public String getTelefone() {
		return telefone;
	}

	public Imovel setTelefone(String telefone) {
		this.telefone = telefone;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public Imovel setEmail(String email) {
		this.email = email;
		return this;
	}
}
