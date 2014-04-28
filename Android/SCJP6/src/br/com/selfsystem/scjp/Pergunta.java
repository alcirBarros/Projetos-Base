package br.com.selfsystem.scjp;

import java.util.List;
import java.util.Map;

public class Pergunta {
	private StringBuilder question = new StringBuilder();
	private Map<Integer, String> opcoes;
	private int resposta;

	public Map<Integer, String> getOpcoes() {
		return opcoes;
	}

	public void setOpcoes(Map<Integer, String> opcoes) {
		this.opcoes = opcoes;
	}

	public int getResposta() {
		return resposta;
	}

	public void setResposta(int resposta) {
		this.resposta = resposta;
	}

	public StringBuilder getQuestion() {
		return question;
	}

	public void setQuestion(StringBuilder question) {
		this.question = question;
	}
}
