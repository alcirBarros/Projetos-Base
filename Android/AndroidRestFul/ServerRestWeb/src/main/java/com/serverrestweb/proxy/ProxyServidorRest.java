package com.serverrestweb.proxy;

import com.serverrestweb.InicioDeJogo;
import com.serverrestweb.Jogador;
import com.serverrestweb.JogoAbandonado;
import com.serverrestweb.LoginEfetuado;
import com.serverrestweb.NavesPosicionadas;
import com.serverrestweb.Partida;
import com.serverrestweb.PedirPosicionamento;
import com.serverrestweb.ReqServidor;
import com.serverrestweb.ResultadoTiro;
import com.serverrestweb.Tiro;
import java.util.LinkedList;
import java.util.List;

public class ProxyServidorRest implements ProxyServidor {

    private Jogador jogador;

    private List<ReqServidor> requisicoes = new LinkedList<ReqServidor>();

    public Jogador getJogador() {
        return jogador;
    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }

    private synchronized void addRequisicao(ReqServidor requisicao) {
        requisicoes.add(requisicao);
    }

    public synchronized ReqServidor getRequisicao() {
        if (requisicoes.size() == 0) {
            return null;
        }
        return requisicoes.remove(0);
    }

    @Override
    public void enviarPedidoPosicionamento() {
        PedirPosicionamento pedirPosicionamento = new PedirPosicionamento();
        addRequisicao(pedirPosicionamento);
    }

    @Override
    public void enviarLoginEfetuado() {
        LoginEfetuado loginEfetuado = new LoginEfetuado();
        loginEfetuado.setId(jogador.getId());
        loginEfetuado.setPosicao(jogador.getPosicao());
        addRequisicao(loginEfetuado);
    }

    @Override
    public void enviarInicioDeJogo(InicioDeJogo inicioDeJogo) {
        addRequisicao(inicioDeJogo);
    }

    @Override
    public void enviarResultadoTiro(ResultadoTiro resultadoTiro) {
        addRequisicao(resultadoTiro);
    }

    @Override
    public void navesPosicionadas(NavesPosicionadas navesPosicionadas) {
        Partida partida = jogador.getPartida();
        partida.navesPosicionadas(jogador, navesPosicionadas.getDadosNaves());
    }

    @Override
    public void atirar(Tiro tiro) {
        Partida partida = jogador.getPartida();
        partida.atirar(jogador, tiro);
    }

    @Override
    public void abandonarJogo() {
        Partida partida = jogador.getPartida();
        partida.abandonarJogo(jogador);
    }

    @Override
    public void enviarJogoAbandonado() {
        JogoAbandonado jogoAbandonado = new JogoAbandonado();
        addRequisicao(jogoAbandonado);
    }

}
