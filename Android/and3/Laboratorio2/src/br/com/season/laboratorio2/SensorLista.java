package br.com.season.laboratorio2;

import android.hardware.Sensor;

public class SensorLista {

	private String nome;
	private Sensor sensor;

	public SensorLista() {

	}

	public SensorLista(String nome, Sensor sensor) {
		this.nome = nome;
		this.sensor = sensor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Sensor getSensor() {
		return sensor;
	}

	public void setSensor(Sensor sensor) {
		this.sensor = sensor;
	}

	@Override
	public String toString() {
		return nome;
	}
}
