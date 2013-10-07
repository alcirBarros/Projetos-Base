package com.conversacao.conversacaojsf.controle;

import com.conversacao.conversacaojsf.conversacao.Conversacao;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.bean.CustomScoped;
import javax.faces.bean.ManagedBean;

/**
 * ManagedBean criado para o teste do escopo pesonalizado de conversa��o
 *
 * @author Gilliard Santos Cordeiro (http://gilliard.eti.br)
 */
@ManagedBean(name = "testeBean")
@CustomScoped("#{conversacao}")
public class TesteBean {

    private String texto;
    private Integer contador;

    @PostConstruct
    public void init() {
        System.out.println("TesteBean.init()");
        contador = 0;
    }

    public String getDataDeHoje() {
        return new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").format(new Date());
    }

    public void incrementarContador() {
        texto = getDataDeHoje();
        contador++;
    }

    public void iniciarConversacao() {
        Conversacao.instancia().iniciar();
    }

    public void finalizarConversacao() {
        Conversacao.instancia().finalizar();
    }

    //-------------------
    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Integer getContador() {
        return contador;
    }

    public void setContador(Integer contador) {
        this.contador = contador;
    }
}
