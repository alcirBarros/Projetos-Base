package com.serverrestweb.proxy;

import com.serverrestweb.InicioDeJogo;
import com.serverrestweb.NavesPosicionadas;
import com.serverrestweb.ResultadoTiro;
import com.serverrestweb.Tiro;

public interface ProxyServidor {

    public void enviarPedidoPosicionamento();

    public void enviarLoginEfetuado();

    public void enviarInicioDeJogo(InicioDeJogo inicioDeJogo);

    public void enviarResultadoTiro(ResultadoTiro resultadoTiro);

    public void enviarJogoAbandonado();

    public void navesPosicionadas(NavesPosicionadas navesPosicionadas);

    public void atirar(Tiro tiro);

    public void abandonarJogo();

}
