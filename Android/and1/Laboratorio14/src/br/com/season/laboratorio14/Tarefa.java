package br.com.season.laboratorio14;

import java.io.Serializable;

public class Tarefa implements Serializable {

	private int id;
	private String titulo;
	private String descricao;
	private boolean concluida;
	
	@Override
	public String toString() {		
		return titulo + " (" + (concluida ? "ok" : "pend") + ")";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isConcluida() {
		return concluida;
	}

	public void setConcluida(boolean concluida) {
		this.concluida = concluida;
	}

}
