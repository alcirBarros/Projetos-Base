package br.com.season.laboratorio13;

public class Noticia {

	private String titulo;
	private String url;
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getUrl() {
		return url;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return titulo;
	}
}
